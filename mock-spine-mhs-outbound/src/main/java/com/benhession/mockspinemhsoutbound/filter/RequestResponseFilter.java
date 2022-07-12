package com.benhession.mockspinemhsoutbound.filter;

import static com.benhession.mockspinemhsoutbound.model.MessageHeaders.CONTENT_TYPE;
import static com.benhession.mockspinemhsoutbound.model.MessageHeaders.MESSAGE_ID;
import static com.benhession.mockspinemhsoutbound.service.ContentTypeService.AMENDED_CONTENT_TYPE;
import static com.benhession.mockspinemhsoutbound.service.ContentTypeService.MHS_OUTBOUND_CONTENT_TYPE;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.benhession.mockspinemhsoutbound.service.ContentTypeService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestResponseFilter extends OncePerRequestFilter {

    private ContentTypeService contentTypeService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);

        Optional<String> headerOptional = Optional.ofNullable(mutableRequest.getHeader(CONTENT_TYPE));
        headerOptional.ifPresent(header -> {
            if (header.equals(MHS_OUTBOUND_CONTENT_TYPE)) {
                mutableRequest.putHeader(CONTENT_TYPE, AMENDED_CONTENT_TYPE);

                Optional<String> messageIdOptional = Optional.ofNullable(mutableRequest.getHeader(MESSAGE_ID));
                messageIdOptional.ifPresent(messageId -> contentTypeService.markAsAlteredContentType(messageId));
            }
        });

        Optional<String> contentTypeOptional = Optional.ofNullable(mutableRequest.getContentType());
        contentTypeOptional.ifPresent(contentType -> {
            if (contentType.equals(MHS_OUTBOUND_CONTENT_TYPE)) {
                mutableRequest.setContentType(AMENDED_CONTENT_TYPE);
            }
        });

        filterChain.doFilter(mutableRequest, response);
    }
}

