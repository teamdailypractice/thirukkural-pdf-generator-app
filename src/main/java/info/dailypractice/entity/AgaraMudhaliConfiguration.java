package info.dailypractice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class AgaraMudhaliConfiguration {

    @JsonProperty("firstKuralId")
    private int firstKuralId;
    @JsonProperty("lastKuralId")
    private int lastKuralId;
    @JsonProperty("startingCharacter")
    private List<String> startingCharacter;
    @JsonProperty("templateFileAbsolutePath")
    private String templateFileAbsolutePath;
    @JsonProperty("outputFilename")
    private String outputFilename;
    @JsonProperty("outputFileAbsolutePath")
    private String outputFileAbsolutePath;

    private String currrentPageName;
    private String previousPageName;
    private String nextPageName;

    private String currentItem;
    private String previousItem;
    private String nextItem;

    public AgaraMudhaliConfiguration() {
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

    public List<String> getStartingCharacter() {
        return startingCharacter;
    }

    public void setStartingCharacter(List<String> startingCharacter) {
        this.startingCharacter = startingCharacter;
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

    public String getCurrrentPageName() {
        return currrentPageName;
    }

    public void setCurrrentPageName(String currrentPageName) {
        this.currrentPageName = currrentPageName;
    }

    public String getPreviousPageName() {
        return previousPageName;
    }

    public void setPreviousPageName(String previousPageName) {
        this.previousPageName = previousPageName;
    }

    public String getNextPageName() {
        return nextPageName;
    }

    public void setNextPageName(String nextPageName) {
        this.nextPageName = nextPageName;
    }

    public String getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(String currentItem) {
        this.currentItem = currentItem;
    }

    public String getPreviousItem() {
        return previousItem;
    }

    public void setPreviousItem(String previousItem) {
        this.previousItem = previousItem;
    }

    public String getNextItem() {
        return nextItem;
    }

    public void setNextItem(String nextItem) {
        this.nextItem = nextItem;
    }

    @Override
    public String toString() {
        return "AgraMudhaliConfiguration{" +
                "firstKuralId=" + firstKuralId +
                ", lastKuralId=" + lastKuralId +
                ", startingCharacter=" + startingCharacter +
                ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
                ", outputFilename='" + outputFilename + '\'' +
                ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgaraMudhaliConfiguration that = (AgaraMudhaliConfiguration) o;
        return firstKuralId == that.firstKuralId && lastKuralId == that.lastKuralId && Objects.equals(startingCharacter, that.startingCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstKuralId, lastKuralId, startingCharacter);
    }
}
