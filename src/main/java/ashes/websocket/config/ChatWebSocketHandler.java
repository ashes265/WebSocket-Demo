//package ashes.websocket.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ChatWebSocketHandler extends TextWebSocketHandler {
//
//    private List<WebSocketSession> sessions = new ArrayList<>();
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        sessions.add(session);
//        session.sendMessage(new TextMessage("Welcome to the chat!"));
//    }
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        // Nhận thông điệp từ client
//        String clientMessage = message.getPayload();
//
//        // Xử lý logic ở đây
//
//        // Gửi phản hồi về client
//        String serverResponse = "Hello from server!";
//        session.sendMessage(new TextMessage(serverResponse));
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        sessions.remove(session);
//    }
//
//    private void broadcastMessage(String message) {
//        TextMessage textMessage = new TextMessage(message);
//        for (WebSocketSession session : sessions) {
//            try {
//                session.sendMessage(textMessage);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
