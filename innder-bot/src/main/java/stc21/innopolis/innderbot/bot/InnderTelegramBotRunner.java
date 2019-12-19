package stc21.innopolis.innderbot.bot;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Component
public class InnderTelegramBotRunner {

    private final InnderTelegramBot telegramBot;

    InnderTelegramBotRunner(InnderTelegramBot telegramBot){
        this.telegramBot = telegramBot;
        this.run();
    }

    public void run() {
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
