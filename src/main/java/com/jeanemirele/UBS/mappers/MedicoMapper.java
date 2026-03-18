package com.jeanemirele.UBS.mappers;

import com.jeanemirele.UBS.domain.entity.Medico;
import com.jeanemirele.UBS.dtos.MedicoCreateDTO;
import com.jeanemirele.UBS.dtos.MedicoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    Medico toEntity(MedicoCreateDTO medicoCreateDTO);
    MedicoResponseDTO toDto(Medico medico);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(MedicoCreateDTO dto, @MappingTarget Medico entity);
}
