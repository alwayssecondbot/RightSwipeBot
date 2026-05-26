package ru.yanes;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

	@Bean
	public ChatClient ollamaChatClient(@Qualifier("ollamaChatModel") ChatModel ollamaModel) {
		return ChatClient.builder(ollamaModel)
				.build();
	}

	@Bean
	public ChatClient openAiChatClient(@Qualifier("openAiChatModel") ChatModel openAiModel) {
		return ChatClient.builder(openAiModel)
				.build();
	}
}
