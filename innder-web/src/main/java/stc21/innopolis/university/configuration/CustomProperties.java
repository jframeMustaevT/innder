package stc21.innopolis.university.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomProperties {

    @Bean(name = "telegramBotUrl")
    public String botUrl(@Value("${bot.telegram.url}") String botUrl){
        return botUrl;
    }

}
