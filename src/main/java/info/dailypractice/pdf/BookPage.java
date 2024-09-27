package info.dailypractice.pdf;

import info.dailypractice.entity.BookConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BookPage {
    private String titleInTamil;
    private String titleInEnglish;
    private int groupId;
    private ArrayList<Map<String, String>> thirukkuralAttributeValueMapList = new ArrayList<>();
    private BookConfiguration bookConfiguration;

    public BookPage() {
    }

    public BookConfiguration getBookConfiguration() {
        return bookConfiguration;
    }

    public void setBookConfiguration(BookConfiguration bookConfiguration) {
        this.bookConfiguration = bookConfiguration;
    }

    public void add(Map<String, String> thirukkuralAttributeValueMap) {
        thirukkuralAttributeValueMapList.add(thirukkuralAttributeValueMap);
    }

    public String getTitleInTamil() {
        return titleInTamil;
    }

    public void setTitleInTamil(String titleInTamil) {
        this.titleInTamil = titleInTamil;
    }

    public String getTitleInEnglish() {
        return titleInEnglish;
    }

    public void setTitleInEnglish(String titleInEnglish) {
        this.titleInEnglish = titleInEnglish;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "BookPage{" +
                "titleInTamil='" + titleInTamil + '\'' +
                ", titleInEnglish='" + titleInEnglish + '\'' +
                ", groupId=" + groupId +
                ", bookConfiguration=" + bookConfiguration +
                '}';
    }

    //    Note: Used in Freemarket Template - content.ftl file
    public List<Map<String, String>> getThirukkuralAttributeValueMapList() {
        return thirukkuralAttributeValueMapList;
    }

}
