package casestudy.service.category;

import casestudy.model.Category;
import casestudy.service.IService;

import java.util.List;

public interface ICategoryDAO extends IService<Category> {
    List<Category> findAllByBookId(int id);
}
