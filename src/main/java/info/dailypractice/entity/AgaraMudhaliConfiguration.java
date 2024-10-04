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
