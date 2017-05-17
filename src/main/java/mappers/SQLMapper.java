package mappers;

import connector.DBConnector;
import entities.Book;
import entities.City;
import interfaces.InterfaceMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Mato on 17.5.17.
 */
public class SQLMapper implements InterfaceMapper{

    DBConnector connector = new DBConnector();
    PreparedStatement ps;

    public SQLMapper() throws ClassNotFoundException {
    }

    public ArrayList<Book> getBookByCity(String city) throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        Connection conn=null;
        try {
            conn= connector.getConnection();
            ps = conn.prepareStatement("select title,author from books join mentioned on " +
                    "books.id_books = mentioned.id_book join cities on " +
                    "cities.id_cities = mentioned.id_city where cities.`name`=?");
            ps.setString(1,city);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(conn!=null){
                conn.close();
            }
        }
        return books;

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
