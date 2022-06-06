package com.dh.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T insertarNuevo(T t) throws Exception;
    List<T> consultarTodos() throws  SQLException;
    T consultarPorId(Integer id) throws SQLException, Exception;
    Boolean actualizar(T t) throws Exception;
    void borrarTodos() throws SQLException;
}
