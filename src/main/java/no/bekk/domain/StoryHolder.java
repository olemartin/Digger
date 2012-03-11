package no.bekk.domain;

public class StoryHolder {
    
    private Story story;
    private String id;
    private Double score;

    public StoryHolder(Story story, String id, Double score) {
        this.story = story;
        this.id = id;
        this.score = score;
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
}
