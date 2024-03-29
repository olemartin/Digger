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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (description != null ? !description.equals(story.description) : story.description != null) return false;
        if (title != null ? !title.equals(story.title) : story.title != null) return false;
        if (url != null ? !url.equals(story.url) : story.url != null) return false;
        if (user != null ? !user.equals(story.user) : story.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
