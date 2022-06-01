package name.com.dh.clinica;

import name.com.dh.clinica.dao.IDao;
import name.com.dh.clinica.dao.impl.PacienteDAOH2;
import name.com.dh.clinica.model.Paciente;
import name.com.dh.clinica.service.PacienteService;

public class Main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente("Arjona", "Lucila", "1234566", "09/08/2021", "san martin 79841");
        paciente.setId(8L);
        PacienteService pacienteservice = new PacienteService();
        pacienteservice.setPacienteIDao(new PacienteDAOH2());
        pacienteservice.guardar(paciente);
        pacienteservice.buscar(8L);

    }
}
