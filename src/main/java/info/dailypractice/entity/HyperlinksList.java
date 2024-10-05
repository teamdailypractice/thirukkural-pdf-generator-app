package info.dailypractice.entity;

import java.util.List;

public class HyperlinksList {
    private String title;
    private List<Hyperlink> hyperlinks;
    private String templateFileAbsolutePath;
    private String outputFileAbsolutePath;

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

    public String getTemplateFileAbsolutePath() {
        return templateFileAbsolutePath;
    }

    public void setTemplateFileAbsolutePath(String templateFileAbsolutePath) {
        this.templateFileAbsolutePath = templateFileAbsolutePath;
    }

    public String getOutputFileAbsolutePath() {
        return outputFileAbsolutePath;
    }

    public void setOutputFileAbsolutePath(String outputFileAbsolutePath) {
        this.outputFileAbsolutePath = outputFileAbsolutePath;
    }

    @Override
    public String toString() {
        return "HyperlinksList{" +
               "title='" + title + '\'' +
               ", hyperlinks=" + hyperlinks +
               ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
               ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
               '}';
    }
}