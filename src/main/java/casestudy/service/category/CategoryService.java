package casestudy.service.category;

import casestudy.config.ConnectionDatabase;
import casestudy.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryDAO{
    Connection connection = ConnectionDatabase.getInstance().getConnect();
    public static final String SELECT_ALL_BOOK = "select * from category;";
    public static  final String FIND_BY_ID = "select * from category where id = ?";
    public static final String SELECT_CATEGORY_BY_BOOK_ID = "select id, type, description from category join book_category bc on category.id = bc.category_id and bc.book_id=?";

    @Override
    public List<Category> selectAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOK);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                Category category = new Category(id, type, description);
                categories.add(category);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }return categories;
    }

    @Override
    public List<Category> selectByName(String name) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void update(int id, Category category) {

    }

    @Override
    public List<Category> findAllByBookId(int book_id) {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement1 = connection.prepareStatement(SELECT_CATEGORY_BY_BOOK_ID);
            statement1.setInt(1, book_id);
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                Category category = new Category(id, type, description);
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findByID(int id) {
        Category category = new Category();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                category = new Category(id, type, description);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }
}
