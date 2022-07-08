package com.benhession.mockspinemhsoutbound.Filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestResponseFilter extends OncePerRequestFilter {

    private static final String CONTENT_TYPE_HEADER = "content-type";
    private static final String MHS_OUTBOUND_CONTENT_TYPE = "multipart/related; boundary=\"--=_MIME-Boundary\"; type=text/xml; start=ebXMLHeader@spine.nhs.uk";
    private static final String AMENDED_CONTENT_TYPE = "multipart/related; boundary=\"--=_MIME-Boundary\"; type=\"text/xml\"; " +
        "start=\"ebXMLHeader@spine.nhs.uk\"";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Filter called");

        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);

        Optional<String> contentTypeOptional = Optional.ofNullable(mutableRequest.getContentType());

        Optional<String> headerOptional = Optional.ofNullable(mutableRequest.getHeader(CONTENT_TYPE_HEADER));

        headerOptional.ifPresent(header -> {
            if (header.equals(MHS_OUTBOUND_CONTENT_TYPE)) {
                mutableRequest.putHeader(CONTENT_TYPE_HEADER, AMENDED_CONTENT_TYPE);
            }
        });

        contentTypeOptional.ifPresent(contentType -> {
            if (contentType.equals(MHS_OUTBOUND_CONTENT_TYPE)) {
                mutableRequest.setContentType(AMENDED_CONTENT_TYPE);
            }
        });

        filterChain.doFilter(mutableRequest, response);
    }
}

