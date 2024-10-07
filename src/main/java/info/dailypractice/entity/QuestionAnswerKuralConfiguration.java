package info.dailypractice.entity;

import java.util.List;

public class QuestionAnswerKuralConfiguration {
    private String title;
    private int firstKuralId;
    private int lastKuralId;
    private List<QuestionAnswerKural> questionAnswerKuralList;
    private String templateFileAbsolutePath;
    private String outputFilename;
    private String outputFileAbsolutePath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFirstKuralId() {
        return firstKuralId;
    }

    public void setFirstKuralId(int firstKuralId) {
        this.firstKuralId = firstKuralId;
    }

    public int getLastKuralId() {
        return lastKuralId;
    }

    public void setLastKuralId(int lastKuralId) {
        this.lastKuralId = lastKuralId;
    }

    public List<QuestionAnswerKural> getQuestionAnswerKuralList() {
        return questionAnswerKuralList;
    }

    public void setQuestionAnswerKuralList(List<QuestionAnswerKural> questionAnswerKuralList) {
        this.questionAnswerKuralList = questionAnswerKuralList;
    }

    public String getTemplateFileAbsolutePath() {
        return templateFileAbsolutePath;
    }

    public void setTemplateFileAbsolutePath(String templateFileAbsolutePath) {
        this.templateFileAbsolutePath = templateFileAbsolutePath;
    }

    public String getOutputFilename() {
        return outputFilename;
    }

    public void setOutputFilename(String outputFilename) {
        this.outputFilename = outputFilename;
    }

    public String getOutputFileAbsolutePath() {
        return outputFileAbsolutePath;
    }

    public void setOutputFileAbsolutePath(String outputFileAbsolutePath) {
        this.outputFileAbsolutePath = outputFileAbsolutePath;
    }

    @Override
    public String toString() {
        return "QuestionAnswerKuralConfiguration{" +
               "title='" + title + '\'' +
               ", firstKuralId=" + firstKuralId +
               ", lastKuralId=" + lastKuralId +
               ", questionAnswerKuralList=" + questionAnswerKuralList +
               ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
               ", outputFilename='" + outputFilename + '\'' +
               ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
               '}';
    }
}
