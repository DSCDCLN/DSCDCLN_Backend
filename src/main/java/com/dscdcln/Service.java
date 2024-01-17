package com.dscdcln;

import com.dscdcln.dto.ChatMessageCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase // 사용자 정의 Component
@RequiredArgsConstructor
@Transactional
class CreateChatMessageService implements ChatMessageCreateUseCase {
    private final CreateChatMessagePort createChatMessagePort;

    @Override
    public Long createChatMessage(ChatMessageCreateCommand command) {
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoomId(new ChatRoom.RoomId(command.roomId()))
                .content(command.content())
                .writer(command.from())
                .build();
        return createChatMessagePort.createChatMessage(chatMessage);
    }
}