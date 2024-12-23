package Managers;

import java.util.List;

public interface IBaseManager<T> {
    public void add(T object);
    public void delete(long id);
    public void update(T object);
    public List<T> getAll();
    public T getById(long id);
    public List<T> getByName(String name);
}
