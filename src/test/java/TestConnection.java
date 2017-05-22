import connector.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mato on 12.5.17.
 */
public class TestConnection {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBConnector dbConnector = new DBConnector();
        Connection con = dbConnector.getConnection();
        System.out.println(con.getMetaData());
    }

}
