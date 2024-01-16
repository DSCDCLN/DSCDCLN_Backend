package com.dscdcln.domain.chat.dto;

import com.dscdcln.domain.chat.domain.ChatRoom;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestChatRoom {
    private Long masterId;

    private String name;

    private Long clubId;

    @Builder
    public RequestChatRoom(Long masterId, String name, Long clubId) {
        this.masterId = masterId;
        this.name = name;
        this.clubId = clubId;
    }

    public ChatRoom toEntity() {
        return ChatRoom.builder()
                .masterId(masterId)
                .name(name)
                .clubId(clubId)
                .build();
    }
}