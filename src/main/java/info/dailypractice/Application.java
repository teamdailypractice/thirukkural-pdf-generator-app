package info.dailypractice;

import info.dailypractice.pdf.Book;
import info.dailypractice.pdf.BookPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Book book;

    public static void main(String[] args) {

        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            System.out.println("My Application - Book");
            List<BookPage> thirukkuralBookPages = book.getBookPages();
            System.out.println(thirukkuralBookPages.size());
//            for (BookPage bookPage : thirukkuralBookPages) {
//                System.out.println(bookPage.getTitle());
//                System.out.println(bookPage.getContents().size());
//            }
        };
    }
}
