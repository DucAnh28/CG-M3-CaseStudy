package casestudy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private Connection connection;

    public static ConnectionJDBC instance = null;

    private ConnectionJDBC() {
    }

    public static ConnectionJDBC getInstance() {
        if (instance == null) {
            return instance = new ConnectionJDBC();
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
        ConnectionJDBC connectionJDBC = ConnectionJDBC.getInstance();
        Connection connection1 = connectionJDBC.getConnect();
        System.out.println(connection1);

    }
}
