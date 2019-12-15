package stc21.innopolis.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@EnableAsync
public class InnderBotApplication {
    public static void main(String[] args) {
        //Initialize application context for telegram bot
        ApiContextInitializer.init();
        SpringApplication.run(InnderBotApplication.class, args);
    }
}
