package com.benhession.mockspinemhsoutbound.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public HttpStatus mockSpineEndpoint(MultipartHttpServletRequest request) throws ServletException, IOException {

        lastMessage = OutboundMessage.builder()
            .headers(request.getRequestHeaders().toString())
            .body(request.getParts().toString())
            .build();

        return HttpStatus.ACCEPTED;
    }

    @PostMapping(path = "/file")
    public void fileUpload(@RequestBody MultipartFile file) {
        System.out.println(file.getSize());
    }


    @GetMapping("/last-message")
    public ResponseEntity<OutboundMessage> fetchLastMessage() {
        Optional<OutboundMessage> messageOptional = Optional.ofNullable(lastMessage);

        return messageOptional.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }
}
