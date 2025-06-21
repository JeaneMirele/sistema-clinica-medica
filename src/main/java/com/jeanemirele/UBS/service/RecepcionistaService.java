package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Recepcionista;
import com.jeanemirele.UBS.exceptions.ResourceNotFoundException;
import com.jeanemirele.UBS.repositorys.RecepcionistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecepcionistaService {
    private final RecepcionistaRepository recepcionistaRepository;

    public List<Recepcionista> findAll() {
        return recepcionistaRepository.findAll();
    }

    public Recepcionista findById(Long id) {
        return recepcionistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recepcionista não cadastrada"));
    }
    public void save (Recepcionista recepcionista) {
        recepcionistaRepository.save(recepcionista);
    }

    public void delete (long id) {
        recepcionistaRepository.deleteById(id);
    }
}
