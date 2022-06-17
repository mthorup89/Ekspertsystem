package dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

    public Connection connect;

    public Connection getConnection() {

        String dbName="expertsystem";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connect;
    }
}
