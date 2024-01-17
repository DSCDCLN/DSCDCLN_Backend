package com.dscdcln.dto;

import lombok.Builder;

@Builder
public record ChatMessageCreateCommand(Long roomId, String content, String from) {
}