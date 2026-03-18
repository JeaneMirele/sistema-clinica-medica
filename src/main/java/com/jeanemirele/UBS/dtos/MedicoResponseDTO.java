package com.jeanemirele.UBS.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String crm;
    private String especialidade;

}
