package ashes.websocket.service.impl;

import ashes.websocket.model.Chat;
import ashes.websocket.model.request.ChatReq;
import ashes.websocket.model.response.ChatResponse;
import ashes.websocket.repository.ChatRepo;
import ashes.websocket.service.ChatService;
import ashes.websocket.utils.TransformUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {
    private final ChatRepo repo;
    private final SimpMessageSendingOperations messagingTemplate;

    @Override
    public void sendMessage(ChatReq req) {
        try {
            Chat entity = new Chat();
            entity.setContent(req.getContent());
            entity.setSenderId(req.getSender());
            entity.setReceiverId(req.getReceiver());
            repo.save(entity);
            messagingTemplate.convertAndSendToUser(req.getReceiver(), "/chat/texting", entity);
            log.info("Add chat successfully");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public List<ChatResponse> getByUsername(String username) {
        List<Chat> chats = repo.getByReceiverIdOrderByCreatedDateDesc(username);
        if (CollectionUtils.isEmpty(chats)) {
            return new ArrayList<>();
        }
        return chats.stream().map(c -> ChatResponse.builder()
                .sender(c.getSenderId())
                .receiver(c.getReceiverId())
                .content(c.getContent())
                .build()).collect(Collectors.toList());
    }
}
