package ashes.websocket.service;

import ashes.websocket.model.request.ChatReq;
import ashes.websocket.model.response.ChatResponse;

import java.util.List;

public interface ChatService {
    void sendMessage(ChatReq req);
    List<ChatResponse> getByUsername(String username);
}
