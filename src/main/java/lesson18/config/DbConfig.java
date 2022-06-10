package lesson18.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

    private final String user = "root";
    private final String pass = "root";
    private final String url = "jdbc:mysql://localhost:3306/hillel_library";

    private final Connection connection;


    public DbConfig() {
        this.connection = createConnection();
    }

    private Connection createConnection(){
        try{
            return DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
