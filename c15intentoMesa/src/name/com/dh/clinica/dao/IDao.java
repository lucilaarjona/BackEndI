package name.com.dh.clinica.dao;

import java.util.List;

public interface IDao <T> {
    public T guardar(T t);
    public void eliminar (long id);
    public T buscar (long id);
    public List<T> buscarTodos();
}
