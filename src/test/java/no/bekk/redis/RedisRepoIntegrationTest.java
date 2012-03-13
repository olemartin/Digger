package no.bekk.redis;

import no.bekk.domain.Story;
import no.bekk.domain.StoryHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/context.xml")
public class RedisRepoIntegrationTest {

    @Autowired
    private RedisRepo repo;
    @Test
    public void testVoting() {
        Story story = new Story("tittel", "url", "description", "user");
        long id = repo.storeStory(story);
        repo.voteOnStory(String.valueOf(id));
        StoryHolder storedStory = repo.getStories().get(0);
        assertEquals(2, storedStory.getScore());
        repo.deleteStory(String.valueOf(id));
    }
}
