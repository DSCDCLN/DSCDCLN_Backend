package com.dscdcln.domain.chat.domain.repository;

import com.dscdcln.domain.chat.dto.ResponseChat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatRepositoryCustom {
    Page<ResponseChat> getChats(Pageable pageable);
}