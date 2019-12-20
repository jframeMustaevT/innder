package stc21.innopolis.innderbot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndividualChatId {

    private String telegramName;

    private String chatId;

    public String getTelegramName() {
        return telegramName;
    }

    public void setTelegramName(String telegramName) {
        this.telegramName = telegramName;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public IndividualChatId(String telegramName, String chatId) {
        this.telegramName = telegramName;
        this.chatId = chatId;
    }
}
