package casestudy.service.book;

import casestudy.config.ConnectionDatabase;
import casestudy.model.Book;
import casestudy.model.Category;
import casestudy.service.category.CategoryService;
import casestudy.service.category.ICategoryDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookDAO {
    Connection connection = ConnectionDatabase.getInstance().getConnect();
    public static final String SELECT_ALL_BOOK = "select * from books;";
    public static final String INSERT_NEW_BOOK = "insert into books (id, code, name, author, price, image, description) VALUE (?, ?, ?, ?, ?, ?, ?);";
    public static final String INSERT_NEW_BOOK_CATEGORY = "insert into book_category (book_id, category_id) VALUE (?, ?);";
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
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(int id, Book book) {

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
