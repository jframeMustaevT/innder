package stc21.innopolis.university.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stc21.innopolis.university.bot.InnderTelegramBot;
import stc21.innopolis.university.entity.RequestToBot;
import stc21.innopolis.university.entity.ResponseOfBot;

@RestController
@RequestMapping(path = "api/bot")
public class BotController {

    InnderTelegramBot innderTelegramBot;

    public BotController(InnderTelegramBot innderTelegramBot) {
        this.innderTelegramBot = innderTelegramBot;
    }

    @RequestMapping(path = "/send_message", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public ResponseOfBot sendMessage(@RequestBody RequestToBot requestToBot){
        String chatId = requestToBot.getChatId();
        String message = requestToBot.getMessage();
        ResponseOfBot response= new ResponseOfBot();
        if (chatId == null || chatId.trim().length()==0
                || message == null || message.trim().length()==0){
            response.setChatId("");
            response.setAnswer("chatId or message are empty");
            // todo add logger
            System.out.println("chatId or message are empty");
            return  response;
        }
        boolean result = innderTelegramBot.sendMessageToChat(chatId, message);
        response.setChatId(chatId);
        response.setAnswer(result? "OK":"Bad: send message fail");
        return response;
    }

}
