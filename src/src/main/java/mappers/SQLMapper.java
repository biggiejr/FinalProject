package mappers;

public interface SQLMapper {

    /**
     * Given a city name this method returns all book titles with corresponding authors that mention this city.
     * @return ArrayList <Book>
     */
    public ArrayList <Book> getBookByCity(String city);

    /**
     * Given a book title, this method plots all cities mentioned in this book.
     * @return ArrayList <City>
     */
    public ArrayList <City> getMentionedCitiesByBook(String bookTitle);

    /**
     * Given an author name this method lists all books written by that author and plots all cities mentioned
     * in any of the books.
     * @return ArrayList <Book>
     */
    public ArrayList <Book> getMentionedCitiesByAuthor(String author);

    /**
     * Given a geolocation, this method lists all books mentioning a city in vicinity of the given geolocation.
     * @return ArrayList <Book>
     */
    public ArrayList <Book> getAllBooksByCity(String location);
}
