package no.bekk.redis;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import no.bekk.domain.Story;
import no.bekk.domain.StoryHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisRepo {

    private static final String STORIES_KEY = "zstories";
    private static final String STORY_ID_INCR = "storyId";


    @Autowired
    private RedisTemplate<String, Story> storyTemplate;

    @Autowired
    private RedisTemplate<String, String> stringTemplate;


    public List<StoryHolder> getFrontPageStories() {
        Set<ZSetOperations.TypedTuple<String>> storyIds =
                stringTemplate.opsForZSet().reverseRangeWithScores(STORIES_KEY, Long.MIN_VALUE, Long.MAX_VALUE);
        List<StoryHolder> stories = new LinkedList<StoryHolder>();
        for (ZSetOperations.TypedTuple<String> tuple : storyIds) {
            stories.add(new StoryHolder(
                    storyTemplate.opsForValue().get(getStoryIdKey(tuple.getValue())),
                    tuple.getValue(), tuple.getScore()));
        }
        return stories;
    }

    public long storeStory(Story story) {
        long id = stringTemplate.opsForValue().increment(STORY_ID_INCR, 1);
        storyTemplate.opsForValue().set(getStoryIdKey(String.valueOf(id)), story);
        stringTemplate.opsForZSet().add(STORIES_KEY, String.valueOf(id), 1);
        return id;
    }

    public void voteOnStory(String storyId) {
        double votes = stringTemplate.opsForZSet().incrementScore(STORIES_KEY, storyId, 1);
        RedisConnection connection = stringTemplate.getConnectionFactory().getConnection();
        try {
            connection.publish("voted".getBytes(), (storyId + ":" + votes).getBytes());
        } finally {
            connection.close();
        }
    }

    private String getStoryIdKey(String id) {
        return "story:" + id;
    }

    public void deleteStory(String id) {
        storyTemplate.opsForZSet().remove(STORIES_KEY, id);
    }
}
