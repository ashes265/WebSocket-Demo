package ashes.websocket.repository;

import ashes.websocket.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepo extends JpaRepository<Chat, String> {
    List<Chat> getByReceiverIdOrderByCreatedDateDesc(String receiver);
}
