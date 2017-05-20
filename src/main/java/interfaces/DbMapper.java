package interfaces;

import entities.Book;
import entities.City;

import java.util.ArrayList;
import java.util.List;

public interface DbMapper {

    /**
     * q1
     * Given a city name this method returns all book titles with corresponding authors that mention this city.
     * @return ArrayList <Book>
     */
    public List <Book> getBookByCity(String city) throws Exception;

    /**
     * q2
     * Given a book title, this method plots all cities mentioned in this book onto map.
     * @return ArrayList <City>
     */
    public ArrayList<City> getMentionedCitiesByBook(String bookTitle) throws Exception;

    /**
     * q3
     * Given an author name this method lists all books written by that author and plots all cities mentioned
     * in any of the books.
     * @return ArrayList <Book>
     */
    public ArrayList <Book> getMentionedCitiesByAuthor(String author);

    /**
     * q4
     * Given a geolocation, this method lists all books mentioning a city in vicinity of the given geolocation.
     * @return ArrayList <Book>
     */
    public ArrayList <Book> getAllBooksByCity(String location);

}
