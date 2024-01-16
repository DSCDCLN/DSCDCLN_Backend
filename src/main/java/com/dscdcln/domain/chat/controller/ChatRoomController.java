package com.dscdcln.domain.chat.controller;

import com.dscdcln.domain.chat.dto.RequestChatRoom;
import com.dscdcln.domain.chat.dto.ResponseChatRoom;
import com.dscdcln.domain.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/room")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final Environment env;

    @PostMapping("/")
    public ResponseEntity<Long> createChatRoom(@RequestBody RequestChatRoom requestChatRoom) {
        Long chatRoomId = chatRoomService.createChatRoom(requestChatRoom);

        return ResponseEntity.status(HttpStatus.CREATED).body(chatRoomId);
    }

    @GetMapping("/{club_id}")
    public ResponseEntity<ResponseChatRoom> getChatRoom(@PathVariable("club_id") Long clubId) {
        ResponseChatRoom responseChatRoom = chatRoomService.getChatRoom(clubId);

        return ResponseEntity.status(HttpStatus.OK).body(responseChatRoom);
    }


    @DeleteMapping("/{chat_room_id}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable("chat_room_id") Long chatRoomId) {
        chatRoomService.deleteChatRoom(chatRoomId);

        return ResponseEntity.noContent().build();
    }
}