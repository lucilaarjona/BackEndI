package com.dh.medicamentos;

import com.dh.medicamentos.dao.IDao;
import com.dh.medicamentos.dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.model.Medicamento;
import com.dh.medicamentos.service.MedicamentoService;

import java.util.logging.Logger;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        // write your code here
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        medicamentoService.buscar(1);
        System.out.println(medicamentoService.buscar(1));


    }
}
