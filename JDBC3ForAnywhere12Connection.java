// Example Java Program - Sybase SQL Anywhere 12 Database Connectivity with JDBC 3.0

/**
 * 
 * Java Program to Connect to Sybase SQL Anywhere 12 Using JDBC 3.0 Driver
*If you want to connect to Sybase SQL Anywhere 12 with JDBC 3.0 driver (sajdbc.jar) use the following code. The only additional item in this program is the loading of driver file. Without the driver configuration, you will encounter the following error,
*No suitable driver found for jdbc:sqlanywhere
*/
import java.sql.*;

public class SybaseExample2 {

    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver( (Driver)
                Class.forName( "sybase.jdbc.sqlanywhere.IDriver" ).newInstance() );
        // uid - user id
        // pwd - password
        // eng - Sybase database server name
        // database - sybase database name
        // host - database host machine ip
        
        String dburl = "jdbc:sqlanywhere:uid=DBA;pwd=DBA;eng=devdb;database=devdb;links=tcpip(host=172.20.20.20)";
        
        // Connect to Sybase Database
        Connection con = DriverManager.getConnection(dburl);
        Statement statement = con.createStatement();

        // We use Sybase specific select getdate() query to return date
        ResultSet rs = statement.executeQuery("SELECT GETDATE()");
        
        
        if (rs.next()) {
            Date currentDate = rs.getDate(1); // get first column returned
            System.out.println("Current Date from Sybase is : "+currentDate);
        }
        rs.close();
        statement.close();
        con.close();
    }
}
