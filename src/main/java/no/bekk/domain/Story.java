package no.bekk.domain;


import java.io.Serializable;

public class Story implements Serializable {
    private String title;
    private String url;
    private String description;
    private String user;


    public Story(String title, String url, String description, String user) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.user = user;
    }

    public Story() {

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
}
