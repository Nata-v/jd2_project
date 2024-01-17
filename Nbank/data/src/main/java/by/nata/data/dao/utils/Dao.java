package by.nata.data.dao.utils;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E>  {
    void save (E entity);
    void delete(K id);
    void update(E entity);
    Optional<E> findById(K id);
    List<E> findAll();
}
