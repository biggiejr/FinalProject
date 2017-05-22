package connector;

import org.neo4j.driver.v1.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by CosticaTeodor on 22/05/2017.
 */
public class Neo4jConnector {

    private String userName = "neo4j";
    private String password = "admin";
    private String url = "bolt://localhost:7474";

    private Driver neo4jDataSource = null;


    public Neo4jConnector() {
        neo4jDataSource = GraphDatabase.driver(url, AuthTokens.basic(userName, password));
    }

    public Session getSession() {

        return neo4jDataSource.session();

    }

}
