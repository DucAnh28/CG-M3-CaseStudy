package casestudy.service;

import casestudy.model.Book;
import casestudy.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomers();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;
}
