package no.bekk.controller;

import no.bekk.redis.RedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FrontPageController {

    @Autowired
    private RedisRepo repo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String execute(Model model) {
        model.addAttribute("stories", repo.getStories());
        return "home";
    }

    @RequestMapping(value = "tagged", method = RequestMethod.GET)
    public String tag(Model model, @RequestParam("tag") String tag) {
        model.addAttribute("stories", repo.getStories(tag));
        return "home";
    }
}
