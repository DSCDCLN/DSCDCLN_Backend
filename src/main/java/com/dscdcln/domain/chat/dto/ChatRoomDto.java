package com.dscdcln.domain.chat.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomDto {
    private Long chatRoomId; // 채팅방 아이디

    private Long masterId;

    private String name;

    private Long clubId;

    @Builder
    public ChatRoomDto(Long chatRoomId, Long masterId, String name, Long clubId) {
        this.chatRoomId = chatRoomId;
        this.masterId = masterId;
        this.name = name;
        this.clubId = clubId;
    }
}