package com.jeanemirele.UBS.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public abstract boolean folgar(boolean escalado);

    public abstract double calcularSalario(Double salario);

}
