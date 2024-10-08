package info.dailypractice.entity;

import java.util.List;

public class HyperlinksWithCountList {
    private String title;
    private List<HyperlinkWithCount> hyperlinksWithCount;
    private String templateFileAbsolutePath;
    private String outputFileAbsolutePath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and Setters
    public List<HyperlinkWithCount> getHyperlinksWithCount() {
        return hyperlinksWithCount;
    }

    public void setHyperlinksWithCount(List<HyperlinkWithCount> hyperlinksWithCount) {
        this.hyperlinksWithCount = hyperlinksWithCount;
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
        return "HyperlinksWithDescriptionList{" +
               "title='" + title + '\'' +
               ", hyperlinks=" + hyperlinksWithCount +
               ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
               ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
               '}';
    }
}