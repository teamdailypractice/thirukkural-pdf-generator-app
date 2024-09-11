package info.dailypractice.pdf;

import info.dailypractice.entity.BookConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookPage {
    private String title;
    private ArrayList<ArrayList<String>> contents = new ArrayList<>();
    private ArrayList<Map<String, String>> lineNumberContentMapList = new ArrayList<>();
    private BookConfiguration bookConfiguration;
    public BookPage() {
    }

    public BookConfiguration getBookConfiguration() {
        return bookConfiguration;
    }

    public void setBookConfiguration(BookConfiguration bookConfiguration) {
        this.bookConfiguration = bookConfiguration;
    }

    public void addThirukkural(List<String> lines) {
        contents.add(new ArrayList<>(lines));
        List<String> contentStructure = bookConfiguration.getContentStructure();
        int LINES_PER_ITEM = contentStructure.size();
        for (int i = 0; i < lines.size(); ) {
            Map<String, String> lineNumberContentMap = new HashMap<>();
            for (int j = 0; j < LINES_PER_ITEM; j++) {
                lineNumberContentMap.put(contentStructure.get(j), lines.get(i + j));
            }
            add(lineNumberContentMap);
            i = i + LINES_PER_ITEM;
        }
    }

    private void add(Map<String, String> lineNumberContentMap) {
        lineNumberContentMapList.add(lineNumberContentMap);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ArrayList<String>> getContents() {
        return contents;
    }

    public List<Map<String, String>> getLineNumberContentMapList() {
        return lineNumberContentMapList;
    }

}
