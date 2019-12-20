package stc21.innopolis.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stc21.innopolis.innderbot.entity.IndividualChatId;
import stc21.innopolis.university.entity.User;
import stc21.innopolis.university.interaction.bot.InteractionWithBot;
import stc21.innopolis.university.service.UserService;


@RestController
@RequestMapping(value = "/api")
public class ApiController {

    final private InteractionWithBot bot;

    final private UserService service;

    public ApiController(InteractionWithBot bot, UserService service) {
        this.bot = bot;
        this.service = service;
    }

    @RequestMapping(value = "/set-chat-id", method = RequestMethod.POST)
    public void saveUserChatId(@RequestBody IndividualChatId individualChatId){
        if (individualChatId.getTelegramName() != null && individualChatId.getChatId()!= null){
            service.saveChatId(individualChatId.getTelegramName(), individualChatId.getChatId());
        }
    }
}
