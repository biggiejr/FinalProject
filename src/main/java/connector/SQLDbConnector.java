package connector;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mato on 12.5.17.
 */
public class SQLDbConnector {


    private final String user = "root";
    private final String password = "admin";
    private final String host = "127.0.0.1";
    private final String port = "3306";
    private final String name = "project";


    private String url ;
    private MysqlDataSource dataSource = null;

    public SQLDbConnector() throws ClassNotFoundException {

        if (dataSource == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url="jdbc:mysql://" + host + ":" + port + "/" + name;
            System.out.println(url);
            dataSource = new MysqlDataSource();

            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setURL(url);
        }


    }

    public Connection getConnection() throws SQLException {

        return dataSource.getConnection();

    }


}
