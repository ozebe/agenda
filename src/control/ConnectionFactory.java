package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public Connection getConnection(String dir, String user, String password) throws ClassNotFoundException, SQLException, IOException {
        //jdbc:postgresql://localhost:5432/example", "postgres", "postgres"
        //usar Connection connection = DriverManager
        return DriverManager.getConnection("jdbc:postgresql:"+dir, user, password);
    }

}
