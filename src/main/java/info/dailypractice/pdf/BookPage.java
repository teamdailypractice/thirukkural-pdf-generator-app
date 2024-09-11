package info.dailypractice.pdf;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookPage {
    private String title;
    private ArrayList<ArrayList<String>> contents = new ArrayList<>();
    private ArrayList<Map<String, String>> lineNumberContentMapList = new ArrayList<>();

    public BookPage() {
    }


    public void addThirukkural(List<String> lines) {
        contents.add(new ArrayList<>(lines));

        int LINES_PER_ITEM = 3;
        for (int i = 0; i < lines.size(); ) {
            Map<String, String> lineNumberContentMap = new HashMap<>();
            lineNumberContentMap.put("lineNumber", lines.get(i));
            lineNumberContentMap.put("a1", lines.get(i + 1));
            lineNumberContentMap.put("a2", lines.get(i + 2));
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
