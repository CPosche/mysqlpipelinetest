import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static String URL = "jdbc:mysql://164.92.175.138:3306/startcode_test?serverTimezone=Europe/Copenhagen";
    private static String USER = "dev";
    private static String PW = "3r!DE32*/fDe";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USER, PW );
        }
        return singleton;
    }

}