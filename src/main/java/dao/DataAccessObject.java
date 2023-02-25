package dao;

import java.util.List;

public abstract class DataAccessObject<E, K> {
    public abstract List<E> selectAll();

    public abstract E selectOne(K id);

    public abstract boolean create(E entity);

    public abstract E update(E entity, K id);

    public abstract boolean delete(K id);
}
