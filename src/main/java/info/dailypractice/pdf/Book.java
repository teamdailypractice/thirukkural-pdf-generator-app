package info.dailypractice.pdf;

import info.dailypractice.dto.ThirukkuralLabelDto;
import info.dailypractice.entity.BookConfiguration;
import info.dailypractice.service.ThirukkuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
        List<ThirukkuralLabelDto> allThirukkural = thirukkuralService
                .getAllThirukkuralWithLabel(getBookConfiguration().getAuthorId(),
                        getBookConfiguration().getFirstKuralId(),
                        getBookConfiguration().getLastKuralId());
        ArrayList<BookPage> bookPages = new ArrayList<>();
//        10 Thirukkural Per page
        for (int i = 0; i < allThirukkural.size(); ) {
            BookPage page = new BookPage();
            page.setBookConfiguration(this.getBookConfiguration());

//            set page title
            page.setTitleInTamil(allThirukkural.get(i).getName_ta());
            page.setTitleInEnglish(allThirukkural.get(i).getName_en());
            page.setTitleGUPope(allThirukkural.get(i).getName_gu_pope());
            page.setGroupId(allThirukkural.get(i).getGroup_id());
            int PER_PAGE_ITEM_COUNT = 10;

            int j = i;
            for (; j < (i + PER_PAGE_ITEM_COUNT) && j < allThirukkural.size(); j++) {
                HashMap<String, String> thirukkuralAttributeValueMap = new HashMap<>();
                ThirukkuralLabelDto thirukkural = allThirukkural.get(j);
//              What is the content for 1 thirukkural?
                thirukkuralAttributeValueMap.put("lineNumber",String.valueOf(thirukkural.getKural_id()));
                thirukkuralAttributeValueMap.put("line1",String.valueOf(thirukkural.getLine1()));
                thirukkuralAttributeValueMap.put("line2",String.valueOf(thirukkural.getLine2()));
                thirukkuralAttributeValueMap.put("urai_1",String.valueOf(thirukkural.getUrai_1()));
                page.add(thirukkuralAttributeValueMap);
            }
            bookPages.add(page);
            i = j;
        }
        return bookPages;
    }
}
