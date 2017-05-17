package mappers;

import entities.Book;
import entities.City;
import interfaces.InterfaceMapper;

import java.util.ArrayList;

/**
 * Created by Mato on 17.5.17.
 */
public class Neo4jMapper implements InterfaceMapper{
    public ArrayList<Book> getBookByCity(String city) {
        return null;
    }

    public ArrayList<City> getMentionedCitiesByBook(String bookTitle) {
        return null;
    }

    public ArrayList<Book> getMentionedCitiesByAuthor(String author) {
        return null;
    }

    public ArrayList<Book> getAllBooksByCity(String location) {
        return null;
    }
}
