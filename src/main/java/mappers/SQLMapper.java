package mappers;

import connector.DBConnector;
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

    DBConnector connector = new DBConnector();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public SQLMapper() throws ClassNotFoundException, IllegalAccessException, SQLException, InstantiationException {
    }

    public ArrayList<Book> getBookByCity(String city) throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        Connection con=null;

        try {
            con= connector.getConnection();
            ps = con.prepareStatement("select title,author from books join mentioned on " +
                    "books.id_books = mentioned.id_book join cities on " +
                    "cities.id_cities = mentioned.id_city where cities.name=?");
            ps.setString(1,city);
            System.out.println("haha");
            rs= ps.executeQuery();
            System.out.println("hahaha");
            while (rs.next()){
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String language = rs.getString(4);
                Book book = new Book(id, title, author, language);
                System.out.println("in");
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
            ps = con.prepareStatement("select cities.name,cities.longitude, cities.lattitude from cities " +
                    "join mentioned on cities.id_cities = mentioned.id_city " +
                    "join books on books.id_books = mentioned.id_book where books.title=?");
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

    public ArrayList<Book> getMentionedCitiesByAuthor(String author) {
        return null;
    }

    public ArrayList<Book> getAllBooksByCity(String location) {
        return null;
    }
}
