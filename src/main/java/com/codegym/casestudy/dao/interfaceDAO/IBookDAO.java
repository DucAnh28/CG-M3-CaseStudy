package com.codegym.casestudy.dao.interfaceDAO;

import com.codegym.casestudy.dao.IGenaralDAO;
import com.codegym.casestudy.model.Book;

import java.util.List;

public interface IBookDAO extends IGenaralDAO<Book> {
    List<Book> findByKeyword(String keyword);

    @Override
    List<Book> showAll();

    @Override
    default boolean add(Book book){
        return false;
    };

    @Override
    default boolean update(int id, Book book){
        return false;
    }

    @Override
    boolean delete(int id);

    @Override
    Book findById(int id);

}
