package connector;






import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
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

    public DBConnector() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        if (dataSource == null) {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
            url="jdbc:mysql://" + host + ":" + port + "/" + name
                    + "?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
