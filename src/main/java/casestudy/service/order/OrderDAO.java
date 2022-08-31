package casestudy.service.order;

import casestudy.config.ConnectionDatabase;
import casestudy.model.Order;
import casestudy.service.customer.CustomerDAO;
import casestudy.service.customer.ICustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    private final String SELECT_ALL_ORDERS = "select * from orders;";
//    private final String SELECT_ALL_ORDERS = "select * from orders;";

    ICustomerDAO customerDAO = new CustomerDAO();
    Connection conection = ConnectionDatabase.getInstance().getConnect();

    public OrderDAO() {
    }

    @Override
    public List<Order> selectAll() {
        List<Order> orderList = new ArrayList<>();
        try{
            PreparedStatement statement = conection.prepareStatement(SELECT_ALL_ORDERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int customer_id = resultSet.getInt("customer_id");
                Date date = resultSet.getDate("dateBuy");
                Order order = new Order(id,customer_id,date);
                orderList.add(order);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> selectByName(String name) {
        return null;
    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void update(int id,Order order) {

    }
}
