package com.benhession.mockspinemhsoutbound.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benhession.mockspinemhsoutbound.model.EhrExtractStatus;
import com.benhession.mockspinemhsoutbound.service.EhrExtractStatusService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/gp2gp-adaptor-db")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EhrExtractStatusController {

    private EhrExtractStatusService extractStatusService;

    @GetMapping(path = "/received-ack/{conversationId}")
    public ResponseEntity<EhrExtractStatus.EhrReceivedAcknowledgement> findReceivedAcknowledgement(@PathVariable String conversationId) {
        Optional<EhrExtractStatus.EhrReceivedAcknowledgement> acknowledgement =
            extractStatusService.findReceivedAcknowledgmentForConversationId(conversationId);

        return acknowledgement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping(path = "/sent-ack/{conversationId}")
    public ResponseEntity<EhrExtractStatus.AckToRequester> findSentAcknowledgement(@PathVariable String conversationId) {
        Optional<EhrExtractStatus.AckToRequester> acknowledgement =
            extractStatusService.findSentAcknowledgementForConversationId(conversationId);

        return acknowledgement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
