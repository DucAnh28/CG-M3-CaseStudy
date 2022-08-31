package casestudy.service.book;

import casestudy.model.Book;
import casestudy.service.IService;

import java.util.List;

public interface IBookDAO extends IService<Book> {
    @Override
    List<Book> selectAll();

    @Override
    List<Book> selectByName(String name);

    @Override
    void delete(Book book);

    @Override
    void save(Book book);

    @Override
    void update(int id, Book book);
}
