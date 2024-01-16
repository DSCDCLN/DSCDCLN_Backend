package com.dscdcln.domain.chat.domain.repository;

import com.dscdcln.domain.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long>, ChatRepositoryCustom {
}