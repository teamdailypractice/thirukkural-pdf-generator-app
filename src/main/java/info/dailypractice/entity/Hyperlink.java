package info.dailypractice.entity;

import java.util.List;

// Class for individual hyperlink
public class Hyperlink {
    private String text;
    private String url;

    // Constructors, Getters and Setters
    public Hyperlink() {}

    public Hyperlink(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Hyperlink{text='" + text + "', url='" + url + "'}";
    }
}

// Class to hold the list of hyperlinks

