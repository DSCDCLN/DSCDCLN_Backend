package com.dscdcln.domain.chat.dto;

import com.dscdcln.domain.chat.domain.Chat;
import com.dscdcln.domain.chat.domain.ChatRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ChatDto {

    private Long chatRoomId; // 방 번호
    private Long senderId;
    private String message;
    private LocalDateTime sendTime;

    public Chat toEntity(ChatRoom chatRoom) {
        return Chat.builder()
                .chatRoom(chatRoom)
                .senderId(senderId)
                .message(message)
                .build();
    }
}