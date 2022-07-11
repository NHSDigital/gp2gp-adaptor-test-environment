package com.benhession.mockspinemhsoutbound.controller;

import static com.benhession.mockspinemhsoutbound.model.Headers.CONTENT_TYPE;
import static com.benhession.mockspinemhsoutbound.model.Headers.CORRELATION_ID;
import static com.benhession.mockspinemhsoutbound.model.Headers.INTERACTION_ID;
import static com.benhession.mockspinemhsoutbound.model.Headers.MESSAGE_ID;
import static com.benhession.mockspinemhsoutbound.service.ContentTypeService.MHS_OUTBOUND_CONTENT_TYPE;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benhession.mockspinemhsoutbound.model.OutboundMessage;
import com.benhession.mockspinemhsoutbound.model.SuccessTemplateParams;
import com.benhession.mockspinemhsoutbound.service.ContentTypeService;
import com.benhession.mockspinemhsoutbound.service.SpineResponseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/reliablemessaging/forwardreliable")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForwardReliableController {

    private SpineResponseService responseService;
    private ContentTypeService contentTypeService;
    private static OutboundMessage lastMessage;

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping(consumes = MediaType.MULTIPART_RELATED_VALUE)
    public ResponseEntity<String> mockSpineEndpoint(@RequestBody String body, @RequestHeader Map<String, String> headers,
        @RequestHeader(value = "message-id") String messageId) {

        Optional<String> contentTypeOptional = Optional.ofNullable(headers.get(CONTENT_TYPE));

        contentTypeOptional.ifPresent(contentType -> {
            if (contentTypeService.hasAlteredContentType(messageId)) {
                headers.put(CONTENT_TYPE, MHS_OUTBOUND_CONTENT_TYPE);
            }
        });

        lastMessage = OutboundMessage.builder()
            .headers(headers)
            .body(body)
            .build();

        var params = SuccessTemplateParams.builder()
            .conversationId(headers.getOrDefault(CORRELATION_ID, ""))
            .interactionId(headers.getOrDefault(INTERACTION_ID, ""))
            .refToMessageId(headers.getOrDefault(MESSAGE_ID, ""))
            .messageId(UUID.randomUUID().toString())
            .timestamp(LocalDateTime.now().toString())
            .build();

        return ResponseEntity.accepted().body(responseService.fillSuccessTemplate(params));
    }

    @GetMapping("/last-message")
    public ResponseEntity<OutboundMessage> fetchLastMessage() {
        Optional<OutboundMessage> messageOptional = Optional.ofNullable(lastMessage);

        return messageOptional.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }
}
