package com.benhession.mockspinemhsoutbound.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.benhession.mockspinemhsoutbound.model.OutboundMessage;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JournalService {

    private static final Map<String, List<OutboundMessage>> REQUEST_JOURNALS_MAP = new HashMap<>();

    public Map<String, List<OutboundMessage>> getRequestJournal() {
        return REQUEST_JOURNALS_MAP;
    }

    public List<OutboundMessage> getRequestJournalById(String correlationId) {
        return REQUEST_JOURNALS_MAP.get(correlationId);
    }

    public void postJournalEntry(String correlationId, OutboundMessage message) {

        addToRequestJournal(correlationId, message);
    }

    private void addToRequestJournal(String correlationId, OutboundMessage message) {
        if(REQUEST_JOURNALS_MAP.containsKey(correlationId)) {
            REQUEST_JOURNALS_MAP.replace(correlationId, Stream.concat(
                    REQUEST_JOURNALS_MAP.get(correlationId).stream(),
                    Stream.of(message)
            ).collect(Collectors.toList()));

            LOGGER.info("Updated Journal entry id: {}" + correlationId);
        } else {
            REQUEST_JOURNALS_MAP.put(correlationId, List.of(message));

            LOGGER.info("Added new Journal entry with id: {}" + correlationId);
        }
    }

}
