package casestudy.service.customer;

import casestudy.model.Customer;
import casestudy.service.IService;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO extends IService<Customer> {
    public Customer findCustomerByAccount(String account);
}
