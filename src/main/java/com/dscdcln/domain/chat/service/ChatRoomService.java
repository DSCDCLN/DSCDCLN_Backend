package com.dscdcln.domain.chat.service;

import com.dscdcln.domain.chat.domain.ChatRoom;
import com.dscdcln.domain.chat.domain.repository.ChatRoomRepository;
import com.dscdcln.domain.chat.dto.RequestChatRoom;
import com.dscdcln.domain.chat.dto.ResponseChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public Long createChatRoom(RequestChatRoom requestChatRoom) {
        ChatRoom result = chatRoomRepository.save(requestChatRoom.toEntity());
        return result.getId();
    }

    public ResponseChatRoom getChatRoom(Long clubId) {
        List<ChatRoom> chatRoomList = chatRoomRepository.findByClubId(clubId);

        return ResponseChatRoom.builder().chatRoomList(chatRoomList).build();
    }

    @Transactional
    public void deleteChatRoom(Long chatRoomId) {
        chatRoomRepository.deleteById(chatRoomId);
    }
}