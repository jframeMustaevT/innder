package stc21.innopolis.innderbot.bot;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import stc21.innopolis.innderbot.interaction.innder.InteractionWithInnder;


@Component
public class InnderTelegramBot extends TelegramLongPollingBot {

    final private String botToken;
    final private InteractionWithInnder innder;

    public InnderTelegramBot(@Qualifier(value = "TelegramToken") String token,
                             InteractionWithInnder innder
    ) {
        super();
        this.botToken = token;
        this.innder = innder;
    }

    @Override
    public synchronized void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String charId = message.getChatId().toString();
            switch (message.getText()) {
                case "/start":
                    String answer = "I'm a bot assistant service Innder. I can help you to use Innder service.\nChoose the available commands:\n" +
                            "/help - in developing\n" +
                            "/setting - in developing\n" +
                            "/hello - I'll say hello))\n";
                    sendMessageToChat(charId, answer);
                    User user = message.getFrom();
                    String telegramName = "";
                    if (user != null && !user.getBot()) {
                        telegramName = user.getUserName();
                    }
                    innder.saveChatId(telegramName, charId);
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

    public synchronized boolean sendMessageToChat(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logger
            System.out.println("Bot don't sens message to chatId: " + chatId);
            e.printStackTrace();
            return false;
        }
        return true;
    }
}