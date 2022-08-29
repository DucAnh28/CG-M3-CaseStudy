package com.codegym.casestudy.dao;

import java.util.List;

public interface IGenaralDAO <T>{
    List<T> showAll();
    boolean add(T t);
    boolean update(int id, T t);
    boolean delete(int id);
    T findById(int id);
}
