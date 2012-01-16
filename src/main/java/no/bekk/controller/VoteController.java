package no.bekk.controller;

import no.bekk.redis.RedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VoteController {

    @Autowired
    private RedisRepo repo;

    @RequestMapping(value = "vote", method = RequestMethod.GET)

    public String vote(@RequestParam("id") String id) {
        repo.voteOnStory(id);
        return "redirect:/";
    }
}
