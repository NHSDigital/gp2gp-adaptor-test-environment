package com.benhession.mockspinemhsoutbound.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.benhession.mockspinemhsoutbound.model.OutboundMessage;

@RestController
@RequestMapping(path = "/reliablemessaging/forwardreliable")
public class ForwardReliableController {

    private OutboundMessage lastMessage;

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping(consumes = MediaType.MULTIPART_RELATED_VALUE)
    public HttpStatus mockSpineEndpoint(@RequestBody String body, @RequestHeader Map<String, String> headers) {

        lastMessage = OutboundMessage.builder()
            .headers(headers)
            .body(body)
            .build();

        System.out.println(lastMessage);

        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/last-message")
    public ResponseEntity<OutboundMessage> fetchLastMessage() {
        Optional<OutboundMessage> messageOptional = Optional.ofNullable(lastMessage);

        return messageOptional.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }
}
