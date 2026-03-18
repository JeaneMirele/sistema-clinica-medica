package com.jeanemirele.UBS.dtos;

import com.jeanemirele.UBS.domain.entity.Endereco;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicoCreateDTO {
    @NotBlank(message = "O nome precisa ser preenchido!")
    private String nome;

    @NotBlank(message = "O telefone precisa ser preenchido!")
    private String telefone;

    @NotBlank(message = "O e-mail precisa ser preenchido!")
    @Column(unique = true)
    @Email(message = "Formato de email inválido.")
    private String email;

    @NotNull(message = "O cargo precisa ser preenchido!")
    private String cargo;

    private double salario;

    private Boolean escalado;

    private Endereco endereco;

    @NotBlank(message = "O crm deve ser preenchido!")
    private String crm;

    @NotBlank(message = "A especialidade precisa ser preenchida!")
    private String especialidade;

}
