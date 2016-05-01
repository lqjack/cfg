/**
*This tutorial is written for Sybase SQL Anywhere 12, 
*Java 1.6 and Sybase JDBC 4.0 driver. 
*You may need different versions of Sybase JDBC drivers for other configurations. 
*However the overall approach remains the same.
*
*Sybase JDBC driver (sajdbc4.jar) is part of Sybase database installation. 
*It is located under the folder C:\Program Files\SQL Anywhere 12\Java in a Windows machine(assuming default installation). 
*Copy sajdbc4.jar to the folder where SybaseExample.java file (see below) is located.**/


// Example Java Program - Sybase SQL Anywhere 12 Database Connectivity with JDBC 4.0
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SybaseExample {

    public static void main(String[] args) throws SQLException {
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


