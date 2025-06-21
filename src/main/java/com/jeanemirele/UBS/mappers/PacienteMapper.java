package com.jeanemirele.UBS.mappers;

import com.jeanemirele.UBS.domain.entity.Paciente;
import com.jeanemirele.UBS.dtos.PacienteCreateDTO;
import com.jeanemirele.UBS.dtos.PacienteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    Paciente toEntity(PacienteCreateDTO pacienteCreateDTO);
    PacienteResponseDTO toDto(Paciente paciente);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(Paciente paciente, @MappingTarget Paciente entity);
}
