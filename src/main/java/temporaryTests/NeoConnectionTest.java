package temporaryTests;

import java.util.ArrayList;

import org.neo4j.driver.v1.Session;

import connector.Neo4jConnector;
import entities.Book;
import mappers.Neo4jMapper;

/**
 * Created by CosticaTeodor on 22/05/2017.
 */
public class NeoConnectionTest {

    public static void main(String[] args) {
        Neo4jConnector neo = new Neo4jConnector();
        Session ses = neo.getSession();
        ses.close();
        Neo4jMapper map= new Neo4jMapper();
        ArrayList<Book> b=map.getBookByCity("Iasi");
        for (Book book : b) {
			System.out.println(book.toString());
		}
    }

}
