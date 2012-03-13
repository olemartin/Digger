package no.bekk.domain;

import java.util.Set;

public class StoryHolder {
    
    private final Story story;
    private final String id;
    private final Double score;
    private final Set<String> tags;

    public StoryHolder(Story story, String id, Double score, Set<String> tags) {
        this.story = story;
        this.id = id;
        this.score = score;
        this.tags = tags;
    }

    public Story getStory() {
        return story;
    }

    public String getId() {
        return id;
    }

    public long getScore() {
        return score.longValue();
    }

    public Set<String> getTags() {
        return tags;
    }
}
