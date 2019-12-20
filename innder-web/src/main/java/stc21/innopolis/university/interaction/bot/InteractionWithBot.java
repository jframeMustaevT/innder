package stc21.innopolis.university.interaction.bot;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import stc21.innopolis.innderbot.entity.RequestToBot;
import stc21.innopolis.innderbot.entity.ResponseOfBot;

@Component
public class InteractionWithBot {

    final private String botUrl;
    final private String send = "/send_message";

    public InteractionWithBot(@Qualifier(value = "telegramBotUrl") String botUrl) {
        this.botUrl = botUrl;
    }

    public boolean sendMessage(String chatId, String message) {
        final RestTemplate restTemplate = new RestTemplate();
        final RequestToBot requestToBot = new RequestToBot(chatId, message);
        try {
            final ResponseOfBot responseOfBot = restTemplate.postForObject(botUrl + send, requestToBot, ResponseOfBot.class);
            return responseOfBot.getAnswer() == "OK";
        }catch (RestClientException e){
            //todo logger
            e.printStackTrace();
            System.out.println("Message to telegram don't send");
        }
        return false;
    }

}
