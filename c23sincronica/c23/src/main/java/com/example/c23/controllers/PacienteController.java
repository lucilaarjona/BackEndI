package com.example.c23.controllers;

import com.example.c23.models.Paciente;
import com.example.c23.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PacienteController {

        @Autowired
        public PacienteService pacienteService;

        @GetMapping("/todos")
        public List<Paciente> getAll(){
            return pacienteService.getAll();
        }

        @GetMapping("/email")
        public String getPacientByEmail(@RequestParam(name="name", required=false, defaultValue="mail@mail.com") String email, Model model){
            Paciente paciente= pacienteService.getPacientByEmail(email);

            if(paciente == null) return "no se encontro paciente con ese email";

            model.addAttribute("name", paciente.getNombre());
            model.addAttribute("surname", paciente.getApellido());
            model.addAttribute("matricula", paciente.getOdontologo().getMatricula());

            return "email";
        }
}

