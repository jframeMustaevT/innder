package stc21.innopolis.university.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import stc21.innopolis.university.interaction.bot.InteractionWithBot;

import javax.transaction.Transactional;

@Controller
//@Transactional
@RequestMapping(value = "/api")
public class ApiController {

    private InteractionWithBot bot;

    public ApiController(InteractionWithBot bot) {
        this.bot = bot;
    }

    public void setUserChatId(){}
}
