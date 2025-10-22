package examen.dao;

import java.util.List;

public interface Dao<T> {
    T findById(int id);
    List<T> findAll();
    boolean insert(T entity);
    boolean update(T entity);
    boolean delete(int id);
}
