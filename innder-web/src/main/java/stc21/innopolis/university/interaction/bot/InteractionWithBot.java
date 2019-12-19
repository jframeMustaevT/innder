package stc21.innopolis.university.interaction.bot;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import stc21.innopolis.innderbot.entity.ResponseOfBot;

@Component
public class InteractionWithBot {

    String botUrl;
    String send = "/send_message";

    public InteractionWithBot(@Qualifier(value = "telegramBotUrl") String botUrl) {
        this.botUrl = botUrl;
    }

    public boolean sendMessage(String chtId, String message){
        final RestTemplate restTemplate = new RestTemplate();
        //final ResponseOfBot =
        String answer = restTemplate.getForObject(botUrl+send, String.class);
        System.out.println(answer);
        return false;
    }

}
