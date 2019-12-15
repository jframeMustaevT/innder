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
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/start":
                    String answer = "I'm a bot assistant service Innder. I can help you to use Innder service.\nChoose the available commands:\n" +
                            "/help - in developing\n" +
                            "/setting - in developing\n" +
                            "/hello - I'll say hello))\n";
                    sendAnswer(message, answer);
                    break;
                case "/hello":
                    sendAnswer(message, "Hello my friend");
                    break;
                case "/help":
                    sendAnswer(message, "In developing");
                    break;
                case "/setting":
                    sendAnswer(message, "In developing");
                    break;
                case "/chat":
                    sendAnswer(message, "ok");
                    startChat(message);
                    break;
                default:
                    sendAnswer(message, "Innder service is still in development.\nWe apologize for the inconvenience!");
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

    private synchronized void sendAnswer(Message message, String answer) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(answer);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public synchronized void startChat(Message message) {
        final Long chatId = message.getChatId();
    }
}