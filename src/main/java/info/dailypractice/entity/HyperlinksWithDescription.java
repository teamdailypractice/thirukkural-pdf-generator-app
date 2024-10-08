package info.dailypractice.entity;

public class HyperlinksWithDescription extends Hyperlink{
    private String description;

    public HyperlinksWithDescription() {
    }

    public HyperlinksWithDescription(String text, String url, String description) {
        super(text, url);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HyperlinksWithDescription{" +
               "description='" + description + '\'' +
               '}';
    }
}
