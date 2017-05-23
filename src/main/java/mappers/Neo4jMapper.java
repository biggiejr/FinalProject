package mappers;

import java.io.IOException;
import java.util.ArrayList;

import api.VicinityLocator;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;
import org.springframework.beans.factory.annotation.Qualifier;

import connector.Neo4jConnector;
import entities.Book;
import entities.City;
import interfaces.DbMapper;
import util.Wrapper;


@Qualifier("neo4j")
public class Neo4jMapper implements DbMapper {
	//Book currentBook;

    private Neo4jConnector connector = new Neo4jConnector();
    VicinityLocator vl = new VicinityLocator();

    public ArrayList<Book> getBookByCity(String city) {
        Session s = connector.getSession();
        ArrayList<Book> books = new ArrayList<Book>();

        String querry = "MATCH (book:Book) - [:MENTIONED]->(city:City) " +
                "WHERE city.city = {cityName} " +
                "RETURN book.id, book.title, book.author";

        StatementResult result = s.run(querry, Values.parameters("cityName", city));


        while (result.hasNext()) {
            Record record = result.next();
            Integer id = Wrapper.getInt(record.
                    get("book.id"));

            String title = record.get("book.title").asString();
            String author = record.get("book.author").asString();
            books.add(new Book(id, title, author, "English"));

        }


        s.close();
        return books;
    }

    public ArrayList<City> getMentionedCitiesByBook(String bookTitle) {
        Session s = connector.getSession();
        ArrayList<City> cities = new ArrayList<City>();

        String querry = "MATCH (book:Book) - [:MENTIONED]->(city:City) " +
                "WHERE book.title = {bookTitle} " +
                "RETURN city.id, city.city, city.latitude, city.longitude";

        StatementResult result = s.run(querry, Values.parameters("bookTitle", bookTitle));


        while (result.hasNext()) {
            Record record = result.next();
            Integer id = Wrapper.getInt(record.
                    get("city.id"));

            String name = record.get("city.name").asString();
            Double latitude = record.get("city.latitude").asDouble();
            Double longitude = record.get("city.longitude").asDouble();

            cities.add(new City(name, latitude, longitude));

        }


        s.close();
        return cities;
    }

    public ArrayList<Book> getMentionedCitiesByAuthor(String author) 
    {

    	Session s = connector.getSession();
    	ArrayList<City> cities = new ArrayList<City>();
    	ArrayList<Book> books = new ArrayList<Book>();

    	String querry = "MATCH (book:Book) - [:MENTIONED]->(city:City) " +
            "WHERE book.author ={author}  " +
            "RETURN book.id, book.title, book.author, book.language, city.city, city.latitude, city.longitude";

    	StatementResult result = s.run(querry, Values.parameters("author", author));

    	Book currentBook=null;
        while(result.hasNext())
        {
        	Record record = result.next();
        	Integer bookId = Wrapper.getInt(record.
                get("book.id"));
        
        	String bookTitle = record.get("book.title").asString();
        	String bookAuthor = record.get("book.author").asString();
        	String bookLanguage = record.get("book.language").asString();
        
        	String cityName = record.get("city.city").asString();
        	Double latitude = Double.parseDouble(record.get("city.latitude").asString());
        	Double longitude = Double.parseDouble(record.get("city.longitude").asString());
        	if (currentBook!=null)
        	{
        		if(!currentBook.getTitle().equals(bookTitle))
        		{
        			books.add(currentBook);
        			currentBook=new Book(bookId,bookTitle,bookAuthor,bookLanguage);
        		}
        	
        	}
        	else currentBook=new Book(bookId,bookTitle,bookAuthor,bookLanguage);
        	currentBook.addCity(new City(cityName, latitude, longitude));
        }
        books.add(currentBook);
        s.close();
        return books;

    }

    public ArrayList<Book> getAllBooksByCity(Double latitude, Double longitude)
    {
        String city = null;
        try {
            city = vl.getCityNameByCoordinates(longitude,latitude);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Session s = connector.getSession();
        ArrayList<Book> books = new ArrayList<Book>();

        String query = "MATCH (city:City)<-[:MENTIONED]-(book:Book) " +
                " WHERE city.city = {cityName} " +
                "RETURN book.id, book.author, book.title";

        StatementResult result = s.run(query, Values.parameters("cityName", city));


        while (result.hasNext()) {
            Record record = result.next();
            Integer id = Wrapper.getInt(record.
                    get("book.id"));

            String title = record.get("book.title").asString();
            String author = record.get("book.title").asString();
            books.add(new Book(id, title, author, "English"));
        }

        s.close();
        return books;

    }
}
