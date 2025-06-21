package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Paciente;
import com.jeanemirele.UBS.exceptions.ResourceNotFoundException;
import com.jeanemirele.UBS.repositorys.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }
    public Paciente findById(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

    }
    public Paciente findByNome(String nome) {
        return pacienteRepository.findByName(nome);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }


}
