package com.benhession.mockspinemhsoutbound.controller;

import com.benhession.mockspinemhsoutbound.model.OutboundMessage;
import com.benhession.mockspinemhsoutbound.service.JournalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/retrieve")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RetrieveSpineController {

    private JournalService journalService;

    @GetMapping
    public ResponseEntity<Map<String, List<OutboundMessage>>> getRecords() {

        return ResponseEntity.ok(journalService.getRequestJournal());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<OutboundMessage>> getRecordById(@PathVariable String id) {

        Optional<List<OutboundMessage>> messagesOptional = journalService.getRequestJournalById(id);

        return messagesOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }


}
