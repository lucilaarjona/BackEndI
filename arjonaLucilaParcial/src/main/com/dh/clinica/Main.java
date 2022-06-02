package main.com.dh.clinica;

import main.com.dh.clinica.dao.impl.OdontologoDAOH2;
import main.com.dh.clinica.model.Odontologo;
import main.com.dh.clinica.service.OdontologoService;

public class Main {
    public static void main(String[] args) {
        Odontologo odontologo = new Odontologo("123456", "Lucila", "Arjona");
        odontologo.setId(8L);
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoIDao(new OdontologoDAOH2());
        odontologoService.guardar(odontologo);
        odontologoService.buscar(8L);

    }
}
