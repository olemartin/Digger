package no.bekk.redis;
    
import no.bekk.domain.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RedisRepo {

    private static final String STORIES_KEY = "zstories";
    private static final String STORY_ID_INCR = "storyId";


    @Autowired
    private StringRedisTemplate template;


    public List<Story> getFrontPageStories() {
        Set<ZSetOperations.TypedTuple<String>> storyIds =
                template.opsForZSet().reverseRangeWithScores(STORIES_KEY, 0, 2000);
        List<Story> stories = new LinkedList<Story>();
        for (ZSetOperations.TypedTuple<String> tuple : storyIds) {
            Map storyMap = template.opsForHash().entries(getStoryIdKey(tuple.getValue()));
            stories.add(Story.fromMap(tuple.getScore().longValue(), tuple.getValue(), storyMap));
        }
        return stories;
    }

    public void storeStory(Story story) {
        long id = template.opsForValue().increment(STORY_ID_INCR, 1);
        template.opsForHash().putAll(getStoryIdKey(String.valueOf(id)), story.toMap());
        template.opsForZSet().add(STORIES_KEY, String.valueOf(id), 1);
    }

    public void voteOnStory(String storyId) {
        template.opsForZSet().incrementScore(STORIES_KEY, storyId, 1);
    }

    private String getStoryIdKey(String id) {
        return "story:" + id;
    }
}
