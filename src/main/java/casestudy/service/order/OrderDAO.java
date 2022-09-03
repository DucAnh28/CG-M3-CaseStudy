package casestudy.service.order;

import casestudy.config.ConnectionDatabase;
import casestudy.model.Cart;
import casestudy.model.Order;
import casestudy.service.customer.CustomerDAO;
import casestudy.service.customer.ICustomerDAO;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    Connection conection = ConnectionDatabase.getInstance().getConnect();

<<<<<<< HEAD
//    Query:
    private final String FIND_ORDERS = "select * from orders where customer_id = ?;";
    private final String CREATE_NEW_ORDERS = "insert into orders (customer_id,dateBuy) values (?,?);";
    private final String CREATE_NEW_ORDERSDETAIL = "insert into ordersdetail (orders_id, book_id, quantity) values (?,?,?);;";
=======

    //    Query:
    private final String FIND_ORDERS = "select * from orders where customer_id = ?;";
    private final String CREATE_NEW_ORDERS = "insert into orders (customer_id,dateBuy) values (?,?);";
    private final String CREATE_NEW_ORDERSDETAIL = "insert into ordersdetail (orders_id, book_id, quantity) values (?,?,?);";
    private final String SHOW_CART = "select name,author,price,image,o.quantity,sum(price*quantity) as 'tong'\n" +
            "from books\n" +
            "join ordersdetail o on books.id = o.book_id\n" +
            "join orders o2 on o2.id = o.orders_id\n" +
            "where customer_id = ? \n" +
            "group by name;";
>>>>>>> master

    public OrderDAO() {
    }

<<<<<<< HEAD
    public void createOrderDetail(int id_customer,int id_book,int quantity){
        Order order = null;
        if (checkOrder(id_customer) == null){
            createNewOrder(id_customer);
            order = checkOrder(id_customer);
        }
        else {
=======

    public List<Cart> getCart(int id){
        List<Cart> cartList = new ArrayList<>();
        try {
            PreparedStatement statement = conection.prepareStatement(SHOW_CART);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
               String name = rs.getString("name");
               String author = rs.getString("author");
               Double price = rs.getDouble("price");
               String img = rs.getString("image");
               int quantity = rs.getInt("quantity");
               Double totalPrice = rs.getDouble("tong");
               Cart cart = new Cart(name,author,price,img,quantity,totalPrice);
               cartList.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartList;
    }

    public void createOrderDetail(int id_customer, int id_book, int quantity) {
        Order order = null;
        if (checkOrder(id_customer) == null) {
            createNewOrder(id_customer);
            order = checkOrder(id_customer);
        } else {
>>>>>>> master
            order = checkOrder(id_customer);
        }
        try {
            PreparedStatement statement = conection.prepareStatement(CREATE_NEW_ORDERSDETAIL);
<<<<<<< HEAD
            statement.setInt(1,order.getId());
            statement.setInt(2,id_book);
            statement.setInt(3,quantity);
=======
            statement.setInt(1, order.getId());
            statement.setInt(2, id_book);
            statement.setInt(3, quantity);
>>>>>>> master
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    public void createNewOrder (int id_customer){
        try {
            PreparedStatement statement = conection.prepareStatement(CREATE_NEW_ORDERS);
            statement.setInt(1,id_customer);
            Date now = Date.valueOf(LocalDate.now());
            statement.setDate(2,now);
=======
    public void createNewOrder(int id_customer) {
        try {
            PreparedStatement statement = conection.prepareStatement(CREATE_NEW_ORDERS);
            statement.setInt(1, id_customer);
            Date now = Date.valueOf(LocalDate.now());
            statement.setDate(2, now);
>>>>>>> master
            statement.executeUpdate();
            System.out.println("Tao thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    public Order checkOrder (int id){
        try {
            PreparedStatement statement = conection.prepareStatement(FIND_ORDERS);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id_order = resultSet.getInt("id");
                int customer_id = resultSet.getInt("customer_id");
                Date date = resultSet.getDate("dateBuy");
                Order order1 = new Order(id_order,customer_id,date);
=======
    public Order checkOrder(int id) {
        try {
            PreparedStatement statement = conection.prepareStatement(FIND_ORDERS);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id_order = resultSet.getInt("id");
                int customer_id = resultSet.getInt("customer_id");
                Date date = resultSet.getDate("dateBuy");
                Order order1 = new Order(id_order, customer_id, date);
>>>>>>> master
                return order1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> selectAll() {
        List<Order> orderList = new ArrayList<>();
//        try{
//            PreparedStatement statement = conection.prepareStatement();
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                int customer_id = resultSet.getInt("customer_id");
//                Date date = resultSet.getDate("dateBuy");
//                Order order = new Order(id,customer_id,date);
//                orderList.add(order);
//            }
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        return orderList;
    }

    @Override
    public List<Order> selectByName(String name) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void update(int id, Order order) {

    }

    @Override
    public Order findByID(int id) {
        return null;
    }

}
