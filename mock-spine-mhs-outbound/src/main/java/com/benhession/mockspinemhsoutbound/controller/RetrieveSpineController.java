package com.benhession.mockspinemhsoutbound.controller;

import com.benhession.mockspinemhsoutbound.service.SpineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/retrieve")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RetrieveSpineController {

    private SpineService spineService;

    @GetMapping
    public ResponseEntity<Map<String, List<String>>> getRecords() {

        return ResponseEntity.ok(spineService.getRequestJournal());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<String>> getRecordById(@PathVariable String id) {

        return ResponseEntity.ok(spineService.getRequestJournalById(id));
    }


}
