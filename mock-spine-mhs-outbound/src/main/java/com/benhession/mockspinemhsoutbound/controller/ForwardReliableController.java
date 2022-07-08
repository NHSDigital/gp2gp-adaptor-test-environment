package com.benhession.mockspinemhsoutbound.controller;

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
import com.benhession.mockspinemhsoutbound.service.SpineResponseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/reliablemessaging/forwardreliable")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForwardReliableController {

    private SpineResponseService responseService;
    private static OutboundMessage lastMessage;

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping(consumes = MediaType.MULTIPART_RELATED_VALUE)
    public ResponseEntity<String> mockSpineEndpoint(@RequestBody String body, @RequestHeader Map<String, String> headers) {

        lastMessage = OutboundMessage.builder()
            .headers(headers)
            .body(body)
            .build();

        var params = SuccessTemplateParams.builder()
            .conversationId(headers.getOrDefault("correlation-id", ""))
            .interactionId(headers.getOrDefault("interaction-id", ""))
            .refToMessageId(headers.getOrDefault("message-id", ""))
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
