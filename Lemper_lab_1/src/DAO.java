import java.util.ArrayList;

public interface DAO<T> {
    boolean create(T obj);
    T read(int id);
    boolean update(T obj);
    boolean delete(T obj);
    ArrayList<T> showAll();
}
