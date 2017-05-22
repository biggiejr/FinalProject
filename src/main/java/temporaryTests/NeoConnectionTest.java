package temporaryTests;

import connector.Neo4jConnector;
import org.neo4j.driver.v1.*;

/**
 * Created by CosticaTeodor on 22/05/2017.
 */
public class NeoConnectionTest {

    public static void main(String[] args) {
        Neo4jConnector neo = new Neo4jConnector();
        Session ses = neo.getSession();
        System.out.println(ses.toString());
        ses.close();
    }

}
