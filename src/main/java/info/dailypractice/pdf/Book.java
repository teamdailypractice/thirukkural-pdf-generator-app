package info.dailypractice.pdf;

import info.dailypractice.dto.ThirukkuralLabelDto;
import info.dailypractice.entity.BookConfiguration;
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
    private BookConfiguration bookConfiguration;

    public Book() {
    }

    public BookConfiguration getBookConfiguration() {
        return bookConfiguration;
    }

    public void setBookConfiguration(BookConfiguration bookConfiguration) {
        this.bookConfiguration = bookConfiguration;
    }

    //Note: This is used in Freemarker template
    public List<BookPage> getBookPages() {
        List<BookPage> thirukkuralPages = getThirukkuralPages();
        bookPages.clear();
        bookPages.addAll(thirukkuralPages);
        return bookPages;
    }

    private List<BookPage> getThirukkuralPages() {
        List<ThirukkuralLabelDto> allThirukkural = thirukkuralService.getAllThirukkuralWithLabel();
        ArrayList<BookPage> bookPages = new ArrayList<>();
//        10 Thirukkural Per page
        for (int i = 0; i < allThirukkural.size(); ) {
            BookPage page = new BookPage();
            page.setBookConfiguration(this.getBookConfiguration());
//            set page title
            page.setTitle(allThirukkural.get(i).getName_ta());
            int PER_PAGE_ITEM_COUNT = 10;
            ArrayList<String> contents = new ArrayList<>();
            int j = i;
            for (; j < (i + PER_PAGE_ITEM_COUNT) && j < allThirukkural.size(); j++) {
                ThirukkuralLabelDto thirukkural = allThirukkural.get(j);
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
