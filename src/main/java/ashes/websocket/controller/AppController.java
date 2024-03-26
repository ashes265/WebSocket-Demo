package ashes.websocket.controller;

import ashes.websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    private final SimpMessagingTemplate textTemplate;

    public AppController(SimpMessagingTemplate textTemplate) {
        this.textTemplate = textTemplate;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message handleMessage(Message message) {
        return message;
    }

    @GetMapping("/test-nhe")
    public void haha() {
        textTemplate.convertAndSend("/topic/messages", "Hello, Tao la Hai");
    }
}
