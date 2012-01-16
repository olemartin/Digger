package no.bekk.domain;


import java.util.HashMap;
import java.util.Map;

public class Story {
    private String id;
    private long score;
    private String title;
    private String url;
    private String description;
    private String user;


    public Story(String id, long score, String title, String url, String description, String user) {
        this.id = id;
        this.score = score;
        this.title = title;
        this.url = url;
        this.description = description;
        this.user = user;
    }

    public Story() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Story{" +
                "score=" + score +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    public static Story fromMap(long score, String id, Map<String, String> map) {
        return new Story(
                id,
                score,
                map.get("title"),
                map.get("url"),
                map.get("description"),
                map.get("user"));
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", getTitle());
        map.put("url", getUrl());
        map.put("description", getDescription());
        map.put("user", getUser());
        return map;
    }
}
