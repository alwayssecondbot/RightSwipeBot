package ru.yanes;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {
	private final ChatClient chatClient;

	// The ChatClient.Builder is automatically configured by the starter
	public AIController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@GetMapping("/ai/joke")
	public AIJoke generateJoke(@RequestParam String topic) {
		return chatClient.prompt()
				.user("Tell me a funny joke about " + topic)
				.system("You are a senior Java architect")
				.call()
				.entity(AIJoke.class);
	}

	@GetMapping("/ai/answer")
	public AIAnswer generateAnswer(@RequestParam String topic) {
		return chatClient.prompt()
				.user("Tell me something about" + topic)
				.call()
				.entity(AIAnswer.class);
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
