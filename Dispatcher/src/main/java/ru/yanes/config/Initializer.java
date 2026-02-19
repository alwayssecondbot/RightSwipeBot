package ru.yanes.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.yanes.controller.RightSwipeBotController;

@Slf4j
@Configuration
public class Initializer {

    @Bean
    public TelegramBotsApi telegramBotsApi(RightSwipeBotController rightSwipeBotController) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(rightSwipeBotController);
            return botsApi;
        } catch (TelegramApiException e) {
            log.error("❌ Ошибка при регистрации бота: {}", e.getMessage());
            throw new RuntimeException("Не удалось зарегистрировать бота", e);
        }
    }
}
