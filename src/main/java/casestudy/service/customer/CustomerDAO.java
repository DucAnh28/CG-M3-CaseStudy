package casestudy.service.customer;

import casestudy.config.ConnectionDatabase;
import casestudy.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class CustomerDAO implements ICustomerDAO {

    Connection connection = ConnectionDatabase.getInstance().getConnect();
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";
    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customer (id,name,age,gender,address,phone,email,account,password,startdate) VALUES (?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select id,name,age,gender,address,phone,email,account,password,startdate from customers where id =?";

    private static final String DELETE_CUSTOMERS_SQL = "delete from customers where id = ?;";
    private static final String UPDATE_CUSTOMERS_SQL = "update customers set name = ?,age = ?, gender = ?, address = ?, phone = ?, email = ?, account = ?, password = ?, startdate = ? where id = ?;";

    public CustomerDAO() {
    }

    @Override
    public List selectAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                Date startDate = resultSet.getDate("startdate");
                customerList.add(new Customer(id,name,age,gender,address,phone,email,account,password,startDate));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Error In SQL");
        }
        return customerList;
    }

    @Override
    public Object selectByName(String name) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(int id, Object o) {

    }
}
