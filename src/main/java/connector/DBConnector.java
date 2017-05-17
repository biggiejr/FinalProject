package connector;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mato on 12.5.17.
 */
public class DBConnector {


    private final String user = "adminzBNmR8r";
    private final String password = "zuzf-vAUPkJp";
    private final String host = "127.5.138.130";
    private final String port = "3306";
    private final String name = "integers";


    private String url ;
    private MysqlDataSource dataSource = null;

    public DBConnector() throws ClassNotFoundException {

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
