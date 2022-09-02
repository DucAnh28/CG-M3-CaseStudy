package casestudy.service.book;

import casestudy.config.ConnectionDatabase;
import casestudy.model.Book;
import casestudy.model.Category;
import casestudy.model.Customer;
import casestudy.service.category.CategoryService;
import casestudy.service.category.ICategoryDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookDAO {
    Connection connection = ConnectionDatabase.getInstance().getConnect();
    public static final String SELECT_ALL_BOOK = "select * from books;";
    public static final String DELETE_BOOK_SQL = "delete from books where id = ?";
    public static final String SELECT_BOOK_BY_ID = "select * from books where id = ?";
    public static final String SELECT_BOOK_BY_NAME = "select * from books where name like ?";
    public static final String SELECT_BOOK_BY_ID = "select * from books where id = ?";
    public static final String INSERT_NEW_BOOK = "insert into books (id, code, name, author, price, image, description) VALUE (?, ?, ?, ?, ?, ?, ?);";
    public static final String INSERT_NEW_BOOK_CATEGORY = "insert into book_category (book_id, category_id) VALUE (?, ?);";
    public static final String UPDATE_BOOK = "update books set code = ?, name = ?, author = ?, price = ?, image = ?, description = ? where id = ?";
    ICategoryDAO categoryDAO = new CategoryService();

    @Override
    public List<Book> selectAll() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOK);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                //lay ra ten, tac gia, mo ta cua sach
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                String description = resultSet.getString("description");
                // lay ra danh sach danh muc theo id cua sach
                List<Category> categories = categoryDAO.findAllByBookId(id);
                Book book = new Book(id, code, name, author, price, image, description, categories);
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> selectByName(String name) {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BOOK_BY_NAME);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String name1 = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                String description = resultSet.getString("description");
                List<Category> categories = categoryDAO.findAllByBookId(id);
                Book book = new Book(id, code, name1, author, price, image, description, categories);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

<<<<<<< HEAD
    @Override
=======
>>>>>>> master
    public List<Book> selectById(int id) {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String code = resultSet.getString("code");
<<<<<<< HEAD
                String name1 = resultSet.getString("name");
=======
                String name = resultSet.getString("name");
>>>>>>> master
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                String description = resultSet.getString("description");
                List<Category> categories = categoryDAO.findAllByBookId(id);
<<<<<<< HEAD
                Book book = new Book(id, code, name1, author, price, image, description, categories);
                books.add(book);

//                System.out.println(books);
=======
                Book book = new Book(id, code, name, author, price, image, description, categories);
                books.add(book);
>>>>>>> master
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
<<<<<<< HEAD
    //    public static void main(String[] args) {
=======



//    public static void main(String[] args) {
>>>>>>> master
//        BookService bookService = new BookService();
//        bookService.selectByName("ba");
//    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(int id, Book book) {

    }
    public void updates(int id, List<Book> books){
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
            statement.setInt(1, books.get(id).getId());
            statement.setString(2, books.get(id).getCode());
            statement.setString(3, books.get(id).getName());
            statement.setString(4, books.get(id).getAuthor());
            statement.setDouble(5, books.get(id).getPrice());
            statement.setString(6, books.get(id).getImage());
            statement.setString(7, books.get(id).getDescription());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saves(Book p, int[] categories) {
        int book_id = 0;

        //b1: ghi thong tin cua sach vao bang book
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement1 = connection.prepareStatement(INSERT_NEW_BOOK, Statement.RETURN_GENERATED_KEYS);
            statement1.setInt(1, p.getId());
            statement1.setString(2, p.getCode());
            statement1.setString(3, p.getName());
            statement1.setString(4, p.getAuthor());
            statement1.setDouble(5, p.getPrice());
            statement1.setString(6, p.getImage());
            statement1.setString(7, p.getDescription());
//            CallableStatement statement1 =
//                    connection.prepareCall("{CALL createNewBook(?, ?, ?)}");
//            statement1.setString(1, p.getName());
//            statement1.setString(2, p.getDescription());
//            statement1.setString(3, p.getAuthor());

            int a1 = statement1.executeUpdate();
            //b2: lay id cua sach vua dc ghi ra
            ResultSet resultSet = statement1.getGeneratedKeys();
            while (resultSet.next()){
                System.out.println(resultSet);
                book_id= resultSet.getInt(1);
            }

            //b3: ghi them ban ghi vao bang trung gian book_category
            //1. book_id, category_id
            PreparedStatement statement = connection.prepareStatement(INSERT_NEW_BOOK_CATEGORY);
            for (int category_id: categories
            ) {
                statement.setInt(1,book_id);
                statement.setInt(2,category_id);
                statement.executeUpdate();
            }
            connection.commit();


        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    @Override
    public Book findByID(int id) {
        return null;
    }
}
