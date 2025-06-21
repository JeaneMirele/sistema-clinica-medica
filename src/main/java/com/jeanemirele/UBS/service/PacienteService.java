package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Paciente;
import com.jeanemirele.UBS.repositorys.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }
    public Paciente findById(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente nao encontrado"));

    }
    public Paciente findByNome(String nome) {
        return pacienteRepository.findByName(nome);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }


}
