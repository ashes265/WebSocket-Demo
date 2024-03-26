package ashes.websocket.controller;

import ashes.websocket.model.request.ChatReq;
import ashes.websocket.model.response.ChatResponse;
import ashes.websocket.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/send")
    public String sendMessage(@Valid @RequestBody ChatReq req) {
        chatService.sendMessage(req);
        return "Send successfully!!";
    }

    @GetMapping("/list")
    public List<ChatResponse> getAll(@RequestParam String username) {
        return chatService.getByUsername(username);
    }
}
