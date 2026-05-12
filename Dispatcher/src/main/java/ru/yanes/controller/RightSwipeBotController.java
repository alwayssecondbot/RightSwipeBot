package ru.yanes.controller;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ru.yanes.config.Config;
import ru.yanes.global.service.impl.CountryServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@Component
public class RightSwipeBotController extends TelegramLongPollingBot {
    private final Config config;
    private final CountryServiceImpl countryService;

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken(){
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String userName = update.getMessage().getFrom().getFirstName();

            log.info("Получено сообщение от {} (chatId: {}): {}", userName, chatId, messageText);

            // Обрабатываем команды
            String response = processCommand(messageText, userName);

            // Отправляем ответ
            sendAnswerMessage(chatId, response);
        }
    }

    private String processCommand(String messageText, String userName) {
        // Приводим к нижнему регистру для сравнения
        String command = messageText.toLowerCase().trim();

        switch (command) {
            case "/start":
                return String.format("👋 Привет, %s! Я простой Telegram бот на Spring Boot!\n\n" +
                        "Доступные команды:\n" +
                        "/help - показать помощь\n" +
                        "/time - текущее время\n" +
                        "/date - текущая дата\n" +
                        "/joke - получить шутку", userName);

            case "/help":
                return "📚 Список команд:\n" +
                        "/start - начать работу\n" +
                        "/help - это сообщение\n" +
                        "/time - показать текущее время\n" +
                        "/date - показать текущую дату\n" +
                        "/joke - рассказать шутку";

            case "/time":
                return "🕐 Текущее время: " +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            case "/date":
                return "📅 Сегодня: " +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            case "/joke":
                return getRandomJoke();

            default:
                return String.format("❌ Команда '%s' не распознана. Введите /help для списка команд.",
                        messageText);
        }
    }

    private String getRandomJoke() {
        String[] jokes = {
                "Почему программисты путают Хэллоуин и Рождество? Потому что Oct 31 == Dec 25!",
                "Встречаются два Java-программиста:\n- Привет! Как дела?\n- Instance of...",
                "Сколько программистов нужно, чтобы вкрутить лампочку?\n- Ни одного, это hardware проблема!",
                "Оптимист учит английский, пессимист - китайский, а программист - язык ассемблера.",
                "Баги - это не ошибки, это недокументированные фичи!"
        };

        int randomIndex = (int) (Math.random() * jokes.length);
        return "😄 " + jokes[randomIndex];
    }

    private void sendAnswerMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        message.setParseMode("HTML");

        try {
            execute(message);
            log.info("Ответ отправлен в чат {}", chatId);
        } catch (TelegramApiException e) {
            log.error("Ошибка при отправке сообщения: {}", e.getMessage());
        }
    }
}