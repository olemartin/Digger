package no.bekk.controller;

import no.bekk.domain.Story;
import no.bekk.redis.RedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddStoryController {

    @Autowired
    private RedisRepo repo;

    @RequestMapping(value ="add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("story", new Story());
        return "add";
    }

    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String add(Story story) {
        repo.storeStory(story);
        return "redirect:/";
    }
}
