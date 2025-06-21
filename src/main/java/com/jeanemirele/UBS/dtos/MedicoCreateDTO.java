package com.jeanemirele.UBS.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoCreateDTO {
    @NotBlank(message = "O nome precisa ser preenchido!")
    private String nome;
    @NotBlank(message = "O crm deve ser preenchido!")
    private String crm;
    @NotBlank(message = "A especialidade precisa ser preenchida!")
    private String especialidade;

}
