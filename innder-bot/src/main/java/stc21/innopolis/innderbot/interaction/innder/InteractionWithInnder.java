package stc21.innopolis.innderbot.interaction.innder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import stc21.innopolis.innderbot.entity.IndividualChatId;

@Component
public class InteractionWithInnder {
    final private String innderUrl;
    final private String sendChatId ="/set-chat-id";

    public InteractionWithInnder(@Qualifier(value = "innderUrl") String innderUrl) {
        this.innderUrl = innderUrl;
    }

    public void saveChatId(String telegramName,  String chatId){
        final IndividualChatId individualChatId = new IndividualChatId(
                telegramName,
                chatId
        );
        final RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.postForLocation(innderUrl + sendChatId, individualChatId);
        }
        catch (RestClientException e){
            //todo Logger
            System.out.println(innderUrl + sendChatId + " - url unavailable");
            e.printStackTrace();
        }
    }
}
