package casestudy.service.customer;

import casestudy.config.ConnectionDatabase;
import casestudy.model.Customer;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    Connection connection = ConnectionDatabase.getInstance().getConnect();
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";
    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customer (id,name,age,gender,address,phone,email,account,password,startdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customers where name =%?%";
    private static final String DELETE_CUSTOMERS_SQL = "delete from customers where id = ?;";
    private static final String UPDATE_CUSTOMERS_SQL = "update customers set name = ?,age = ?, gender = ?, address = ?, phone = ?, email = ?, account = ?, password = ?, startdate = ? where id = ?;";

    public CustomerDAO() {
    }

    @Override
    public List<Customer> selectAll() {
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
    public List<Customer> selectByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            statement.setString(1,"'%"+name+"%'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                Date startDate = resultSet.getDate("startdate");
                Customer customer = new Customer(id,name1,age,gender,address,phone,email,account,password,startDate);
                customerList.add(customer);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customerList;
    public Customer selectByName(String name) {
        Customer
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void save(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMERS_SQL);
            statement.setInt(1,customer.getId());
            statement.setString(2,customer.getName());
            statement.setInt(3,customer.getAge());
            statement.setString(4, customer.getGender());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAccount());
            statement.setString(9, customer.getPassword());
            statement.setDate(10, customer.getStartDate());
            statement.executeUpdate();
            System.out.println("Thanh cong");
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(int id, Customer customer) {

    }

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
//        customerDAO.save(new Customer(2,"ducanh",22,"Male","HN","0969282458","ducanh@gmail.com","ducanh123","ducanh123",Date.valueOf(LocalDate.now())));
        customerDAO.selectByName("duc");

    }
}
