package stc21.innopolis.university;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.telegram.telegrambots.ApiContextInitializer;
import stc21.innopolis.university.bot.TokenStorage;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
@EnableAsync
public class InnderBotApplication {
    public static void main(String[] args) {
        //Initialize application context for telegram bot
        ApiContextInitializer.init();
        SpringApplication.run(InnderBotApplication.class, args);
    }

    @Bean(name = "TelegramToken")
    String getTelegramToken(){
        final XmlMapper xmlMapper = new XmlMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("telegram_token.xml")) {
            TokenStorage tokenStorage = xmlMapper.readValue(new String(inputStream.readAllBytes()), TokenStorage.class);
            return tokenStorage.getToken();
        } catch (IOException e) {
            //todo add logger
            e.printStackTrace();
            System.out.println("Token storage not found");
        }
        return "";
    }
}
