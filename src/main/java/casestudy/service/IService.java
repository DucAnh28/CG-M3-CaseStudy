package casestudy.service;

import java.util.List;

public interface IService<T> {
    List<T> selectAll();
    T selectByName(String name);
    void delete(T t);
    void save(T t);
    void update(int id,T t);
}
