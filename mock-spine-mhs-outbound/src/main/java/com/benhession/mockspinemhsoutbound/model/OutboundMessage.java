package com.benhession.mockspinemhsoutbound.model;

import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class OutboundMessage {
    @NonNull
    private Map<String, String> headers;
    @NonNull
    private String body;
}
