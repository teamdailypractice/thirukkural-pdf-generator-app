package info.dailypractice.pdf;

import info.dailypractice.entity.Thirukkural;
import info.dailypractice.service.ThirukkuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Book {
    private ArrayList<BookPage> bookPages = new ArrayList<>();
    @Autowired
    private ThirukkuralService thirukkuralService;

    public Book() {
    }
    public List<BookPage> getBookPages() {
        if (bookPages.isEmpty()) {
            List<BookPage> thirukkuralPages = getThirukkuralPages();
            bookPages.addAll(thirukkuralPages);
        }
        return bookPages;
    }

    private BookPage getPage(String title) {
        BookPage page = new BookPage();
        page.setTitle(title);
        for (int i = 0; i < 10; i++) {
            ArrayList<String> contents = new ArrayList<>();
            contents.add(String.valueOf(i));
            contents.add("Line");
            page.add(contents);
        }
        return page;
    }

    private List<BookPage> getThirukkuralPages() {
        List<Thirukkural> allThirukkural = thirukkuralService.findAll();
        ArrayList<BookPage> bookPages = new ArrayList<>();
//        10 Thirukkural Per page
        for (int i = 0; i < allThirukkural.size(); ) {
            BookPage page = new BookPage();
//            set page title
            page.setTitle(String.valueOf(i + 1));
            int PER_PAGE_ITEM_COUNT = 10;
            ArrayList<String> contents = new ArrayList<>();
            int j = i;
            for (; j < (i + PER_PAGE_ITEM_COUNT) && j < allThirukkural.size(); j++) {
                Thirukkural thirukkural = allThirukkural.get(j);
//              What is the content for 1 thirukkural?
                contents.add(String.valueOf(thirukkural.getKural_id()));
                contents.add(thirukkural.getLine1());
                contents.add(thirukkural.getLine2());
            }
            page.addThirukkural(contents);
            bookPages.add(page);
            i = j;
        }
        return bookPages;
    }
}
