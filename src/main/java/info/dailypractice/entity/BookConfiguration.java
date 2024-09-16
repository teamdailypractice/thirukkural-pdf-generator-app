package info.dailypractice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookConfiguration {

    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("authorId")
    private int authorId;
    @JsonProperty("contentStructure")
    private List<String> contentStructure;
    @JsonProperty("templateFileAbsolutePath")
    private String templateFileAbsolutePath;
    @JsonProperty("outputFileAbsolutePath")
    private String outputFileAbsolutePath;

    public BookConfiguration() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public List<String> getContentStructure() {
        return contentStructure;
    }

    public void setContentStructure(List<String> contentStructure) {
        this.contentStructure = contentStructure;
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
        return "BookConfiguration{" +
                "bookName='" + bookName + '\'' +
                ", authorId=" + authorId +
                ", contentStructure=" + contentStructure +
                ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
                ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookConfiguration that = (BookConfiguration) o;
        return authorId == that.authorId && Objects.equals(bookName, that.bookName) && Objects.equals(templateFileAbsolutePath, that.templateFileAbsolutePath) && Objects.equals(outputFileAbsolutePath, that.outputFileAbsolutePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, authorId, templateFileAbsolutePath, outputFileAbsolutePath);
    }
}
