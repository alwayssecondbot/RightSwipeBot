package ru.yanes.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("application.yml")
public class Config {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.version}")
    private String botVersion;

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.adminChatId}")
    private String adminChatId;

    @Value("${bot.supportChatId}")
    private String supportChatId;

    @Value("${bot.uri}")
    private String botUri;

    @Value("${bot.path}")
    private String botPath;

}
