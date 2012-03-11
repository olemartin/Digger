package no.bekk.controller;

import java.util.List;

import no.bekk.domain.StoryHolder;
import no.bekk.redis.RedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FrontPageController {

    @Autowired
    private RedisRepo repo;

    private List<StoryHolder> getFrontPageStories() {
        return repo.getFrontPageStories();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String execute(Model model) {
        model.addAttribute("stories", getFrontPageStories());
        return "home";
    }
}
