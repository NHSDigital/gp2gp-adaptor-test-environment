package com.benhession.mockspinemhsoutbound.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.ACCEPTED;

@Slf4j
public class RetrieveSpineService {

    private static final Map<String, List<String>> REQUEST_JOURNALS_MAP = new HashMap<>();

    private final HttpHeaders headers = new HttpHeaders();

    public Map<String, List<String>> getRequestJournal() {
        return REQUEST_JOURNALS_MAP;
    }

    public List<String> getRequestJournalById(String correlationId) {
        return REQUEST_JOURNALS_MAP.get(correlationId);
    }

    public ResponseEntity<String> postJournalEntry(String message) {

        headers.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<>(message, headers, ACCEPTED);
    }

    private void addToRequestJournal(String correlationId, String message) {
        if(REQUEST_JOURNALS_MAP.containsKey(correlationId)) {
            REQUEST_JOURNALS_MAP.replace(correlationId, Stream.concat(
                    REQUEST_JOURNALS_MAP.get(correlationId).stream(),
                    Stream.of(message)
            ).collect(Collectors.toList()));

            log.info("Updated Journal entry id: {}" + correlationId);
        } else {
            REQUEST_JOURNALS_MAP.put(correlationId, List.of(message));

            log.info("Added new Journal entry with id: {}" + correlationId);
        }
    }

}
