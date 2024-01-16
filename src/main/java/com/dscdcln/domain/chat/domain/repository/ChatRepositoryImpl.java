package com.dscdcln.domain.chat.domain.repository;

import com.dscdcln.domain.chat.dto.ResponseChat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRepositoryImpl implements ChatRepositoryCustom {

    @Override
    public Page<ResponseChat> getChats(Pageable pageable) {
        // Implementation of getChats method
        return null;
    }
}