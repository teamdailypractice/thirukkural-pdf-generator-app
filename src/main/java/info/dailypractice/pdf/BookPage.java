package info.dailypractice.pdf;

import info.dailypractice.entity.BookConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookPage {
    private String title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                "title='" + title + '\'' +
                ", groupId=" + groupId +
                ", bookConfiguration=" + bookConfiguration +
                '}';
    }

    //    Note: Used in Freemarket Template - content.ftl file
    public List<Map<String, String>> getThirukkuralAttributeValueMapList() {
        return thirukkuralAttributeValueMapList;
    }

}
