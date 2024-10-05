package info.dailypractice.entity;

import java.util.List;

public class HyperlinksWithDescriptionList {
    private String title;
    private List<HyperlinkWithDescription> hyperlinksWithDescription;
    private String templateFileAbsolutePath;
    private String outputFileAbsolutePath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and Setters
    public List<HyperlinkWithDescription> getHyperlinksWithDescription() {
        return hyperlinksWithDescription;
    }

    public void setHyperlinksWithDescription(List<HyperlinkWithDescription> hyperlinksWithDescription) {
        this.hyperlinksWithDescription = hyperlinksWithDescription;
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
               ", hyperlinks=" + hyperlinksWithDescription +
               ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
               ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
               '}';
    }
}