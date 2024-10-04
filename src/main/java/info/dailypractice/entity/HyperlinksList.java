package info.dailypractice.entity;

import java.util.List;

public class HyperlinksList {
    private String title;
    private List<Hyperlink> hyperlinks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and Setters
    public List<Hyperlink> getHyperlinks() {
        return hyperlinks;
    }

    public void setHyperlinks(List<Hyperlink> hyperlinks) {
        this.hyperlinks = hyperlinks;
    }

    @Override
    public String toString() {
        return "HyperlinksList{" +
               "title='" + title + '\'' +
               ", hyperlinks=" + hyperlinks +
               '}';
    }
}