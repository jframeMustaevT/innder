package stc21.innopolis.university.bot;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "TokenStorage")
//Класс описывающий структуру telegram_token.xml в котором хранится токен бота telegram
public class TokenStorage {
    @JacksonXmlProperty(isAttribute = true, localName = "Token")
    private String token;

    public TokenStorage() {
    }

    public TokenStorage(String token) {
        this();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
