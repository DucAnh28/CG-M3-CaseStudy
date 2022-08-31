package casestudy.service.book;

import casestudy.model.Book;
import casestudy.service.IService;

import java.util.List;

public interface IBookDAO extends IService<Book> {
    public void saves(Book p, int[] categories);
}
