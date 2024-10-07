package info.dailypractice.entity;

public class ThirukkuralTopicsConfiguration {

    private String title;
    private String description;
    private int firstTopicId;
    private int lastTopicId;
    private String templateFileAbsolutePath;
    private String outputFileAbsolutePath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFirstTopicId() {
        return firstTopicId;
    }

    public void setFirstTopicId(int firstTopicId) {
        this.firstTopicId = firstTopicId;
    }

    public int getLastTopicId() {
        return lastTopicId;
    }

    public void setLastTopicId(int lastTopicId) {
        this.lastTopicId = lastTopicId;
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
        return "ThirukkuralTopicConfiguration{" +
               "title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", firstTopicId=" + firstTopicId +
               ", lastTopicId=" + lastTopicId +
               ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
               ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
               '}';
    }
}
