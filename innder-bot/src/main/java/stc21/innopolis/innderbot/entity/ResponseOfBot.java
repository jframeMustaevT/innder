package stc21.innopolis.innderbot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseOfBot {

    private String chatId = "";

    private String answer = "";

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ResponseOfBot(String chatId, String answer) {
        this.chatId = chatId;
        this.answer = answer;
    }
}
