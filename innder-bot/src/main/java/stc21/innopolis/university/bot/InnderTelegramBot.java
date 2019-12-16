package stc21.innopolis.university.bot;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class InnderTelegramBot extends TelegramLongPollingBot {

    private String botToken;

    public InnderTelegramBot(@Qualifier(value = "TelegramToken") String token) {
        super();
        this.botToken = token;
    }

    @Override
    public synchronized void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String charId = message.getChatId().toString();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/start":
                    String answer = "I'm a bot assistant service Innder. I can help you to use Innder service.\nChoose the available commands:\n" +
                            "/help - in developing\n" +
                            "/setting - in developing\n" +
                            "/hello - I'll say hello))\n";
                    sendMessageToChat(charId, answer);
                    break;
                case "/hello":
                    sendMessageToChat(charId, "Hello my friend");
                    break;
                case "/help":
                    sendMessageToChat(charId, "In developing");
                    break;
                case "/setting":
                    sendMessageToChat(charId, "In developing");
                    break;
                default:
                    sendMessageToChat(charId, "Innder service is still in development.\nWe apologize for the inconvenience!");
                    break;
            }
        }
    }

    @Override
    public synchronized String getBotUsername() {
        return "InnderBot";
    }

    @Override
    public synchronized String getBotToken() {
        return this.botToken;
    }

    public synchronized boolean sendMessageToChat(String chatId, String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logger
            System.out.println("Bot don't sens message to chatId: "+chatId);
            e.printStackTrace();
            return false;
        }
        return true;
    }
}