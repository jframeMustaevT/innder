package stc21.innopolis.university.bot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Service
public class InnderTelegramBotRunner implements CommandLineRunner {

    private final InnderTelegramBot telegramBot;

    InnderTelegramBotRunner(InnderTelegramBot telegramBot){
        this.telegramBot = telegramBot;
    }

    @Override
    @Async
    public void run(String... args) throws Exception {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this.telegramBot);
        } catch (TelegramApiRequestException e) {
            //todo logger
            System.out.println("Fail on create telegram bot");
            e.printStackTrace();
        }
    }
}
