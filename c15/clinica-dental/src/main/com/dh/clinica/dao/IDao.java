package main.com.dh.clinica.dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    public T guardar(T t);
    public Optional<T> buscar(Integer id);
    public void eliminar(Integer id);
    public List<T> buscarTodos();

}
