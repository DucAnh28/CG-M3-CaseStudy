package casestudy.service.book;

import casestudy.config.ConnectionDatabase;
import casestudy.crawlsData.CrawlsDataBook;
import casestudy.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookDAO {
    Book book = new Book();
    CrawlsDataBook crawlsDataBook = new CrawlsDataBook();
    public static final String SELECT_ALL_BOOK="select * from books;";
    private static final String SELECT_BOOK_BY_NAME="select id, code, name, author_id, price, category_id, image, description from books where name = ?";
    public static final String INSERT_NEW_BOOK="insert into books(id, code, name, author_id, price, category_id, image, description) value (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String INSERT_NEW_BOOK_CATEGORY="insert into category(id, type, description) value(?, ?, ?);";
    Connection connection = ConnectionDatabase.getInstance().getConnect();

    @Override
    public List<Book> selectAll() {
        List<Book> books = new ArrayList<>();
        try {
//            Connection connection = ConnectionDatabase.instance.getConnect();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOK);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                //lay ra ten, tac gia, mo ta cua sach
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                int author_id = resultSet.getInt("author_id");
                double price = resultSet.getDouble("price");
                int category_id = resultSet.getInt("category_id");
                String image = resultSet.getString("image");
                String description = resultSet.getString("description");
                Book book = new Book(id, code,name, author_id, price, category_id, image, description);
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        List<Book> list = bookService.selectAll();
        bookService.addAll();
         for (Book x: list
             ) {
            System.out.println(x.toString());
        }
    }

    @Override
    public List<Book> selectByName(String name) {
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                int author_id = resultSet.getInt("author_id");
                double price = resultSet.getDouble("price");
                int category_id = resultSet.getInt("category_id");
                String image = resultSet.getString("image");
                String description = resultSet.getString("description");
                book = new Book(id, code,name, author_id, price, category_id, image, description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void save(Book book) {
        System.out.println(INSERT_NEW_BOOK);
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BOOK)){
            for (int i = 1; i <= 10; i++) {
                preparedStatement.setInt(1, crawlsDataBook.getData().get(i).getId());
                preparedStatement.setString(2, crawlsDataBook.getData().get(i).getCode());
                preparedStatement.setString(3, crawlsDataBook.getData().get(i).getName());
                preparedStatement.setInt(4, crawlsDataBook.getData().get(i).getAuthor_id());
                preparedStatement.setDouble(5, crawlsDataBook.getData().get(i).getPrice());
                preparedStatement.setInt(6, crawlsDataBook.getData().get(i).getCategory_id());
                preparedStatement.setString(7, crawlsDataBook.getData().get(i).getImage());
                preparedStatement.setString(8, crawlsDataBook.getData().get(i).getDescription());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            }

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("loi roi");
        }
    }
    public void addAll(){
        for (int i = 1; i <= 5; i++) {
//            System.out.println(INSERT_NEW_BOOK);
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BOOK)) {
                preparedStatement.setInt(1, crawlsDataBook.getData().get(i).getId());
                preparedStatement.setString(2, crawlsDataBook.getData().get(i).getCode());
                preparedStatement.setString(3, crawlsDataBook.getData().get(i).getName());
                preparedStatement.setInt(4, crawlsDataBook.getData().get(i).getAuthor_id());
                preparedStatement.setDouble(5, crawlsDataBook.getData().get(i).getPrice());
                preparedStatement.setInt(6, crawlsDataBook.getData().get(i).getCategory_id());
                preparedStatement.setString(7, crawlsDataBook.getData().get(i).getImage());
                preparedStatement.setString(8, crawlsDataBook.getData().get(i).getDescription());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("loi roi");
            }
        }
//            preparedStatement.executeUpdate();
    }

    @Override
    public void update(int id, Book book) {

    }
}
