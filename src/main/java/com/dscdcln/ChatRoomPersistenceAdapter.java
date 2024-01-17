package com.dscdcln;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter // 사용자 정의 Component
@RequiredArgsConstructor
class ChatRoomPersistenceAdapter implements CreateChatRoomPort {
    private final SpringDataChatRoomRepository springDataChatRoomRepository;

    @Transactional
    @Override
    public boolean createChatRoom(ChatRoom chatRoom) {
        ChatRoomJpaEntity chatRoomJpaEntity = ChatRoomJpaEntity.builder()
                .build();
        springDataChatRoomRepository.save(chatRoomJpaEntity);
        return true;
    }
}