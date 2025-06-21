package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Medico;
import com.jeanemirele.UBS.repositorys.ConsultaRepository;
import com.jeanemirele.UBS.repositorys.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final ConsultaRepository consultaRepository;

    public MedicoService(MedicoRepository medicoRepository, ConsultaRepository consultaRepository) {
        this.medicoRepository = medicoRepository;
        this.consultaRepository = consultaRepository;
    }

    public List<Medico> findAll() {
      return medicoRepository.findAll();
    }

    public Medico findByID(long id) {
       return medicoRepository.findById(id).orElseThrow(()
               -> new RuntimeException("Medico não encontrado"));
    }

    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    public void delete(long id) {
        medicoRepository.deleteById(id);
    }
}
