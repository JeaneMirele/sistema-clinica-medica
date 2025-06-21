package com.jeanemirele.UBS.repositorys;

import com.jeanemirele.UBS.domain.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
