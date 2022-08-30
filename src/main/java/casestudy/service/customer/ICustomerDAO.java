package casestudy.service.customer;

import casestudy.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomerByName(int id);

    public List<Customer> selectAllCustomers();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;
}
