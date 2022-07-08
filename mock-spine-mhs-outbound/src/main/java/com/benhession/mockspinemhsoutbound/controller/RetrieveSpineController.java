package com.benhession.mockspinemhsoutbound.controller;

import com.benhession.mockspinemhsoutbound.service.RetrieveSpineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/retrieve")
public class RetrieveSpineController {

    @Autowired
    private RetrieveSpineService retrieveSpineService;

    @GetMapping
    public ResponseEntity<Map<String, List<String>>> getRecords() {

        return ResponseEntity.ok(retrieveSpineService.getRequestJournal());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<String>> getRecordById(@PathVariable String id) {

        return ResponseEntity.ok(retrieveSpineService.getRequestJournalById(id));
    }

//    @PostMapping
//    public ResponseEntity<String> addRecord(
//            @RequestHeader Map<String, String> headers,
//            @RequestBody(required=false) String mockMhsMessage) {
//
//        return ResponseEntity.accepted(retrieveSpineService.addToRequestJournal());
//    }
}
