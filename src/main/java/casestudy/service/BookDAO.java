package casestudy.service;

import casestudy.config.ConnectionJDBC;
import casestudy.model.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.println;

public class BookDAO {

    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customers (id,name,age,gender,address,phone,email,account,password,startdate) VALUES (?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select id,name,age,gender,address,phone,email,account,password,startdate from customers where id =?";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customers";
    private static final String DELETE_CUSTOMERS_SQL = "delete from customers where id = ?;";
    private static final String UPDATE_CUSTOMERS_SQL = "update customers set name = ?,age = ?, gender = ?, address = ?, phone = ?, email = ?, account = ?, password = ?, startdate = ? where id = ?;";

    public BookDAO() {
    }
    public void inserCustomer(Customer customer) throws SQLException {
            System.out.println(INSERT_CUSTOMERS_SQL);
        try(ConnectionJDBC connectionJDBC = getConnection();PreparedStatement preparedStatement = connectionJDBC.pre){
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setInt(3,customer.getAge());
            preparedStatement.setString(4,customer.getGender());
            preparedStatement.setString(5,customer.getAddress());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAccount());
            preparedStatement.setString(9,customer.getPassword());
            preparedStatement.setDate(10, (Date) customer.getStartdate());

        }
    }


    }
}
