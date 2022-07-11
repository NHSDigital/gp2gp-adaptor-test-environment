package com.benhession.mockspinemhsoutbound.controller;

import com.benhession.mockspinemhsoutbound.service.SpineService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/send")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SendSpineController {

    private SpineService spineService;

    @PostMapping
    public ResponseEntity<String> addRecord(
            @RequestHeader Map<String, String> headers,
            @RequestBody(required=false) String message) {

        String correlationId = Optional.ofNullable(headers.get("correlation-id")).orElse(StringUtils.EMPTY);

        return spineService.postJournalEntry(correlationId, message);
    }
}
