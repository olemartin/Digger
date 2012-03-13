package no.bekk.controller;

import no.bekk.redis.RedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TagController {

    @Autowired
    private RedisRepo repo;

    @RequestMapping(value = "tag", method = RequestMethod.GET)
    public Model add(Model model, @RequestParam("tag") String tag, @RequestParam("story") String story) {
        repo.tagStory(story, tag);
        model.addAttribute("tags", repo.getStoryTags(story));
        return model;
    }
}
