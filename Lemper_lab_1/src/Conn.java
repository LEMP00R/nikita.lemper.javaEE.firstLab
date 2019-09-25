import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conn {
    public static Connection conn;

    public static Connection GetConn() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:ShopDB.db");
        return conn;
    }

}