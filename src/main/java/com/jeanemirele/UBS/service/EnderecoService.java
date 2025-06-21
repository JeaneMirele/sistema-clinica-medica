package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Endereco;
import com.jeanemirele.UBS.repositorys.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco findById(long id) {
        return enderecoRepository.findById(id).orElseThrow(()-> new RuntimeException("Endereco no encontrado"));
    }
    public void save(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void delete(long id){
        enderecoRepository.deleteById(id);
    }

}
