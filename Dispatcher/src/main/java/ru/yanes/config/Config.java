package ru.yanes.config;


import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Configuration
@ConfigurationProperties(prefix = "bot")
public class Config {

    private String name;
    private String version;
    private String token;
    private String adminChatId;
    private String supportChatId;
    private String uri;
    private String path;
}
