package com.benhession.mockspinemhsoutbound.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class OutboundMessage {
    @NonNull
    private String headers;
    @NonNull
    private String body;
}
