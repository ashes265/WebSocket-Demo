package ashes.websocket.controller;

import ashes.websocket.model.request.MessageReq;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageReq handleMessage(MessageReq messageReq, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", messageReq.getSender());
        return messageReq;
    }
}
