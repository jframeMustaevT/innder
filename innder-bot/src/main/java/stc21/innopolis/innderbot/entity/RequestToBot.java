package stc21.innopolis.innderbot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestToBot {
    private String chatId ="";

    private String message = "";

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RequestToBot(String chatId, String message) {
        this.chatId = chatId;
        this.message = message;
    }
}
