package ashes.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebSocketApplication {

	public static void main(String[] args) {
		// Stomp Js Library: https://cdnjs.com/libraries/stomp.js
		SpringApplication.run(DemoWebSocketApplication.class, args);
	}
}
