package name.com.dh.clinica.service;

import name.com.dh.clinica.dao.IDao;
import name.com.dh.clinica.model.Domicilio;
import name.com.dh.clinica.model.Paciente;

import java.util.List;

public class DomicilioService {
    private IDao<Domicilio> domicilioIDao;
    public IDao<Domicilio> getDomicilioIDao() {
        return domicilioIDao;
    }

    public void setDomicilioIDao(IDao<Domicilio> domicilioIDao) {
        this.domicilioIDao = domicilioIDao;
    }

    public Domicilio guardar(Domicilio domicilio){
        return domicilioIDao.guardar(domicilio);
    }
    public void eliminar (Long id){
        domicilioIDao.eliminar(id);
    }
    public Domicilio buscar(Long id){
        return domicilioIDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicilioIDao.buscarTodos();
    }
}
