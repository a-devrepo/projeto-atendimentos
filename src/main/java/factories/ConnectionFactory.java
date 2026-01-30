package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private final String HOST = "jdbc:postgresql://localhost:5432/bd-atendimentos";
    private final String USER = "postgres";
    private final String PASSWORD = "admin123";

    private static ConnectionFactory connectionFactory;

    private ConnectionFactory(){}

    public static ConnectionFactory getConnectionFactory() {
        if(connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(HOST, USER, PASSWORD);
    }
}
