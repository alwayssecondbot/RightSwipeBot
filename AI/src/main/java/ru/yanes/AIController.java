package ru.yanes;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
public class AIController {
	private final ChatClient openAiChatClient;
	private final ChatClient ollamaChatClient;

	AIController(@Qualifier("openAiChatClient") ChatClient openAiChatClient, @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
		this.openAiChatClient = openAiChatClient;
		this.ollamaChatClient = ollamaChatClient;
	}

	@GetMapping("/ai/joke")
	public AIJoke generateJoke(@RequestParam String topic) {
		return ollamaChatClient.prompt()
				.user("Tell me a funny joke about " + topic)
				.call()
				.entity(AIJoke.class);
	}

	@GetMapping("/ai/translate")
	public TranslatorAnswer translate(@RequestParam String message, @RequestParam String targetLang) {
		var template = """
				Translate the following message into {targetLang}.
				And identify the original language. Message: {message}.
				""";

		return openAiChatClient.prompt()
				.user(u -> u.text(template)
						.param("message", message)
						.param("targetLang", targetLang))
				.call()
				.entity(TranslatorAnswer.class);
	}

	@GetMapping("/ai/explain")
	public String generateAnswer(@RequestParam String topic, @RequestParam String level) {
		var template = """
			Explain the concept of {topic} to me.
			Keep it brief, but use a {level} tone.
			""";

		return openAiChatClient.prompt()
				.user(u -> u.text(template)
						.param("topic", topic)
						.param("level", level))
				.call()
				.content();
	}

	@GetMapping(value = "/ai/answer-stream", produces = TEXT_EVENT_STREAM_VALUE)
	public Flux<String> generateAnswerStream(@RequestParam String topic) {
		return openAiChatClient.prompt()
				.user(topic)
				.stream()
				.content();
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
