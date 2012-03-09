package no.bekk.redis;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import no.bekk.domain.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisRepo {

    private static final String STORIES_KEY = "zstories";
    private static final String STORY_ID_INCR = "storyId";


    @Autowired
    private RedisTemplate<String,Story> storyTemplate;
    
    @Autowired
    private RedisTemplate<String, String> genericTemplate;


    public List<Story> getFrontPageStories() {
        Set<ZSetOperations.TypedTuple<String>> storyIds =
                genericTemplate.opsForZSet().reverseRangeWithScores(STORIES_KEY, 0, Long.MAX_VALUE);
        List<Story> stories = new LinkedList<Story>();
        for (ZSetOperations.TypedTuple<String> tuple : storyIds) {
            Story story = storyTemplate.opsForValue().get(getStoryIdKey(tuple.getValue()));
            story.setScore(tuple.getScore().longValue());
            story.setId(tuple.getValue());
            stories.add(story);
        }
        return stories;
    }

    public void storeStory(Story story) {
        long id = genericTemplate.opsForValue().increment(STORY_ID_INCR, 1);
        storyTemplate.opsForValue().set(getStoryIdKey(String.valueOf(id)), story);
        genericTemplate.opsForZSet().add(STORIES_KEY, String.valueOf(id), 1);
    }

    public void voteOnStory(String storyId) {
        genericTemplate.opsForZSet().incrementScore(STORIES_KEY, storyId, 1);
    }

    private String getStoryIdKey(String id) {
        return "story:" + id;
    }
}
