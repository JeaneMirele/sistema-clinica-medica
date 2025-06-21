package com.jeanemirele.UBS.repositorys;

import com.jeanemirele.UBS.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    public Paciente findByName(String nome);
}
