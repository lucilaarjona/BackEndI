package com.dh.clinica.controller;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.impl.DomicilioDaoH2;
import com.dh.clinica.repository.impl.PacienteDaoH2;
import com.dh.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService = new PacienteService(
            new PacienteDaoH2(new DomicilioDaoH2()));

    /*private final PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }*/

    @PostMapping("/new")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null) {
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id){
        ResponseEntity<Paciente> response = null;

        if(pacienteService.buscar(id) != null){
            response = ResponseEntity.ok(pacienteService.buscar(id));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    /*Se almacena la ejecución del método buscar() dentro de una variable. Luego si dicha
    variables es null, significa que no encontró el "id" y arroja Status 404 Not Found
            Caso contrario, eliminar el Paciente y arroja Status 200.ok.*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        var isInDataBase= pacienteService.buscar(id);

        if(isInDataBase == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            pacienteService.eliminar(id);
            response = ResponseEntity.ok("Paciente: " + id + " eliminado.");
        }
        return response;
    }

    @GetMapping("/all")
    public ResponseEntity <List<Paciente>> buscarTodos(){
        ResponseEntity<List<Paciente>> response = null;

        if(pacienteService.buscarTodos().isEmpty()){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            response = ResponseEntity.ok(pacienteService.buscarTodos());
        }
        return response;
    }

}
