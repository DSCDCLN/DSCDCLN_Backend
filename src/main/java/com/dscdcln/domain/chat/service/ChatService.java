package com.dscdcln.domain.chat.service;

import com.dscdcln.domain.chat.domain.ChatRoom;
import com.dscdcln.domain.chat.domain.repository.ChatRepository;
import com.dscdcln.domain.chat.domain.repository.ChatRoomRepository;
import com.dscdcln.domain.chat.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public void saveMessage(ChatDto chat) {
        ChatRoom chatRoom = chatRoomRepository.findById(chat.getChatRoomId())
                .orElseThrow(() -> new NoSuchElementException("ChatRoom not found with id: " + chat.getChatRoomId()));

        chatRepository.save(chat.toEntity(chatRoom));
    }

    public Page getChats(Pageable pageable) {
        return chatRepository.getChats(pageable);
    }
}