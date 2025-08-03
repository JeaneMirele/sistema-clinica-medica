package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Medico;
import com.jeanemirele.UBS.dtos.MedicoCreateDTO;
import com.jeanemirele.UBS.exceptions.ResourceNotFoundException;
import com.jeanemirele.UBS.mappers.MedicoMapper;
import com.jeanemirele.UBS.repositorys.ConsultaRepository;
import com.jeanemirele.UBS.repositorys.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final ConsultaRepository consultaRepository;
    private final MedicoMapper medicoMapper;

    public List<Medico> findAll() {
      return medicoRepository.findAll();
    }

    public Medico findByID(long id) {
       return medicoRepository.findById(id).orElseThrow(()
               -> new ResourceNotFoundException("Medico não encontrado"));
    }

    @Transactional
    public void update(Long id, MedicoCreateDTO medicoCreateDto) {
        Medico medico = findByID(id);
        medicoMapper.updateEntityFromDto(medicoCreateDto, medico);
    }

    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    public void delete(long id) {
        medicoRepository.deleteById(id);
    }
}
