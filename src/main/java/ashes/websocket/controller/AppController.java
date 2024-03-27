package ashes.websocket.controller;

import ashes.websocket.model.request.MessageReq;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AppController {

    // For test html
    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public MessageReq handleMessage(MessageReq messageReq, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", messageReq.getSender());
        return messageReq;
    }
}
