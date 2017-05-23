package mappers;

import connector.SQLDbConnector;
import entities.Book;
import entities.City;
import interfaces.DbMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Mato on 17.5.17.
 */
@Qualifier("sql")
public class SQLMapper implements DbMapper{

    SQLDbConnector connector = new SQLDbConnector();
    PreparedStatement ps;

    public SQLMapper() throws ClassNotFoundException {
    }
    
    public ArrayList<Book> getBookByCity(String city) throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        Connection con=null;
        try {
            con= connector.getConnection();
            ps = con.prepareStatement(
            		"select books.id_books, title,author "+
            		"from books, mentioned, cities "+
            		"where books.id_books = mentioned.id_book and "+
            		"cities.id_cities = mentioned.id_city and "+
            		"cities.name=?;"
            		);

            ps.setString(1,city);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                //String language = rs.getString(4);
                Book book = new Book(id, title, author, "English");
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(con!=null){
                con.close();
            }
        }
        return books;

    }

    public ArrayList<City> getMentionedCitiesByBook(String bookTitle) throws Exception {
        ArrayList<City> places = new ArrayList<City>();
        Connection con = null;
        try {
            con = connector.getConnection();
            ps = con.prepareStatement(
            		"select cities.name, cities.longitude, cities.lattitude "+
            		"from books,cities, mentioned "+
            		"where books.id_books=mentioned.id_book "+
            		"and  mentioned.id_city=cities.id_cities "+
            		"and books.title=?"
                    );
            ps.setString(1,bookTitle);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString(1);
                Double longitude = rs.getDouble(2);
                Double latitude = rs.getDouble(3);
                City city = new City(name, longitude, latitude);
                places.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(con!=null){
                con.close();
            }
        }
        return places;

    }

    public ArrayList<Book> getMentionedCitiesByAuthor(String author) 
    {
        return null;
    }

    public ArrayList<Book> getAllBooksByCity(Double latitude, Double longitude) {
		return null;
	}
    
}
