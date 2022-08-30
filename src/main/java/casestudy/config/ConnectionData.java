package casestudy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionData {
    private Connection connection;

    public static ConnectionData instance = null;

    private ConnectionData() {
    }

    public static ConnectionData getInstance() {
        if (instance == null) {
            return instance = new ConnectionData();
        }
        return instance;
    }

    private static final String URL = "jdbc:mysql://localhost:3306/casestudy3";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public Connection getConnect(){
        if (connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                System.out.println("ket noi thanh cong");
            }
            catch (ClassNotFoundException | SQLException e){
                System.out.println("ket noi khong thanh cong");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        ConnectionData connectionData = ConnectionData.getInstance();
        Connection connection1 = connectionData.getConnect();
        System.out.println(connection1);

    }
}
