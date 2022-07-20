package extensions;

import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.extension.requestfilter.RequestFilterAction;
import com.github.tomakehurst.wiremock.extension.requestfilter.RequestWrapper;
import com.github.tomakehurst.wiremock.extension.requestfilter.StubRequestFilter;
import com.github.tomakehurst.wiremock.http.Request;

import model.Payload;

public class JwtOdsExtractor extends StubRequestFilter {

    @Override
    public RequestFilterAction filter(Request request) {

        Optional<String> authHeader = Optional.ofNullable(request.getHeader("Authorization"));

        if(authHeader.map(header -> header.startsWith("Bearer")).orElse(false)) {

            String odsCode = parseOds(authHeader.get()).orElse("");

            Request wrappedRequest = RequestWrapper.create()
                .addHeader("ods-code", odsCode)
                .wrap(request);

            return RequestFilterAction.continueWith(wrappedRequest);
        }

        return RequestFilterAction.continueWith(request);
    }

    @Override
    public String getName() {
        return "jwt-ods-Header-extractor";
    }

    public Optional<String> parseOds(String authHeader) {

        String[] chunks = authHeader.split("\\.");

        Base64.Decoder decoder = Base64.getDecoder();
        ObjectMapper mapper = new ObjectMapper();

        try {
            String payloadString = new String(decoder.decode(chunks[1]));
            Payload payload = mapper.readValue(payloadString, Payload.class);

            List<Payload.RequestingOrganization.Identifier> identifiers = payload.getRequestingOrganization().getIdentifierList();

            return identifiers.stream()
                .filter(Payload.RequestingOrganization.Identifier::isOdsCode)
                .map(Payload.RequestingOrganization.Identifier::getValue)
                .findFirst();

        } catch (NoSuchElementException | JsonProcessingException e) {
            return Optional.empty();
        }
    }
}
