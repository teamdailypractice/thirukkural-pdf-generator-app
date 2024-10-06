package info.dailypractice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PdfFontSettings {
    @JsonProperty("englishFontName")
    private String englishFontName;
    @JsonProperty("englishBodyFontSize")
    private float englishBodyFontSize;
    @JsonProperty("englishHeadingFontSize")
    private float englishHeadingFontSize;
    @JsonProperty("tamilFontName")
    private String tamilFontName;
    @JsonProperty("tamilBodyFontSize")
    private float tamilBodyFontSize;
    @JsonProperty("tamilHeadingFontSize")
    private float tamilHeadingFontSize;

    public String getEnglishFontName() {
        return englishFontName;
    }

    public void setEnglishFontName(String englishFontName) {
        this.englishFontName = englishFontName;
    }

    public float getEnglishBodyFontSize() {
        return englishBodyFontSize;
    }

    public void setEnglishBodyFontSize(float englishBodyFontSize) {
        this.englishBodyFontSize = englishBodyFontSize;
    }

    public float getEnglishHeadingFontSize() {
        return englishHeadingFontSize;
    }

    public void setEnglishHeadingFontSize(float englishHeadingFontSize) {
        this.englishHeadingFontSize = englishHeadingFontSize;
    }

    public String getTamilFontName() {
        return tamilFontName;
    }

    public void setTamilFontName(String tamilFontName) {
        this.tamilFontName = tamilFontName;
    }

    public float getTamilBodyFontSize() {
        return tamilBodyFontSize;
    }

    public void setTamilBodyFontSize(float tamilBodyFontSize) {
        this.tamilBodyFontSize = tamilBodyFontSize;
    }

    public float getTamilHeadingFontSize() {
        return tamilHeadingFontSize;
    }

    public void setTamilHeadingFontSize(float tamilHeadingFontSize) {
        this.tamilHeadingFontSize = tamilHeadingFontSize;
    }

    @Override
    public String toString() {
        return "PdfFontSettings{" +
               "englishFontName='" + englishFontName + '\'' +
               ", englishBodyFontSize=" + englishBodyFontSize +
               ", englishHeadingFontSize=" + englishHeadingFontSize +
               ", tamilFontName='" + tamilFontName + '\'' +
               ", tamilBodyFontSize=" + tamilBodyFontSize +
               ", tamilHeadingFontSize=" + tamilHeadingFontSize +
               '}';
    }
}
