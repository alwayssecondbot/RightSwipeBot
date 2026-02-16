package ru.yanes.controller;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ru.yanes.config.Config;

@Slf4j
@RequiredArgsConstructor
@Component
public class RightSwipeBotController extends TelegramLongPollingBot {
    private final Config config;

    @Override
    public void onUpdateReceived(Update update) {
        var originalMessage = update.getMessage();
        log.debug(originalMessage.getText());

        var responce = new SendMessage();
        responce.setChatId(originalMessage.getChatId().toString());
        responce.setText("Lol");
        sendAnswerMessage(responce);

    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    public void sendAnswerMessage(SendMessage message){
        if (message != null){
            try {
                execute(message);
            } catch (TelegramApiException e){
                log.error(e.getMessage());
            }
        }
    }
}