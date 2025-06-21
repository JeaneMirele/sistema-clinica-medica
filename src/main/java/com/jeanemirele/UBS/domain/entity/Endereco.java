package com.jeanemirele.UBS.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A rua precisa ser preenchida!")
    private String rua;
    @NotBlank(message = "A cidade precisa ser preenchida!")
    private String cidade;
    @NotBlank(message = "O estado precisa ser preenchido!")
    private String estado;
    @NotBlank(message = "O cep precisa ser preenchido!")
    private String cep;
    @NotBlank(message = "O Número precisa ser preenchido!")
    private String numero;
    @NotBlank(message = "O bairro precisa ser preenchido!")
    private String bairro;
}
