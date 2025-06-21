package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Recepcionista;
import com.jeanemirele.UBS.repositorys.RecepcionistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepcionistaService {
    private RecepcionistaRepository recepcionistaRepository;

    public RecepcionistaService(RecepcionistaRepository recepcionistaRepository) {
        this.recepcionistaRepository = recepcionistaRepository;
    }

    public List<Recepcionista> findAll() {
        return recepcionistaRepository.findAll();
    }

    public Recepcionista findById(Long id) {
        return recepcionistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Recepcionista não cadastrada"));
    }
    public void save (Recepcionista recepcionista) {
        recepcionistaRepository.save(recepcionista);
    }

    public void delete (long id) {
        recepcionistaRepository.deleteById(id);
    }
}
