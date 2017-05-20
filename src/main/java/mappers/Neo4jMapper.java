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
@Qualifier("neo4j")
public class Neo4jMapper implements DbMapper {

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
