package mappers;

import entities.Book;
import entities.City;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;


/**
 * Created by Mato on 17.5.17.
 */
@RunWith(MockitoJUnitRunner.class)
class Neo4jMapperTest {

    @Mock
    City city;

    @Mock
    Book book;


    @Before
    public void setup() {
        ArrayList<Book> bookArrayList = new ArrayList<Book>();

        Book book1 = new Book(1, "book1", "author1", "English");
        Book book2 = new Book(2, "book2", "author2", "English");
        Book book3 = new Book(3, "book3", "author3", "English");
        Book book4 = new Book(4, "book4", "author4", "English");

//        City city1 = new City("Dubai","","");
//        City city2 = new City("Copenhagen","","");
//        City city3 = new City("Stockholm","","");
//        City city4 = new City("Paris","","");

        bookArrayList.add(book1);
        bookArrayList.add(book2);
        bookArrayList.add(book3);
        bookArrayList.add(book4);
    }
    @Test
    void getBookByCity() {
    }

    @Test
    void getMentionedCitiesByBook() {
    }

    @Test
    void getMentionedCitiesByAuthor() {
    }

    @Test
    void getAllBooksByCity() {
    }

}