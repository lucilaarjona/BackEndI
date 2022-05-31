package name.com.dh.clinica.service;

import name.com.dh.clinica.dao.IDao;
import name.com.dh.clinica.model.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public IDao<Paciente> getPacienteIDao() {
        return pacienteIDao;
    }

    public void setPacienteIDao(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }
    public void eliminar (Long id){
        pacienteIDao.eliminar(id);
    }
    public Paciente buscar(Long id){
        return pacienteIDao.buscar(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }

}
