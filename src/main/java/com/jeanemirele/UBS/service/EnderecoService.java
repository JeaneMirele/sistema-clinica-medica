package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Endereco;
import com.jeanemirele.UBS.exceptions.ResourceNotFoundException;
import com.jeanemirele.UBS.repositorys.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco findById(long id) {
        return enderecoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Endereco não encontrado"));
    }
    public void save(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void delete(long id){
        enderecoRepository.deleteById(id);
    }

}
