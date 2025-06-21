package com.jeanemirele.UBS.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "tb_pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @NotBlank(message = "O nome precisa ser preenchido!")
    private String nome;

    @NotNull(message = "O telefone precisa ser preenchido!")
    private String telefone;

    @NotNull(message = "O e-mail precisa ser preenchido!")
    @Column(unique = true)
    @Email(message = "Formato de email inválido.")
    private String email;

    @NotNull(message = "O cpf precisa ser preenchido")
    @Column(unique = true)
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido (ex: 123.456.789-00)")
    private String cpf;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @NotNull(message = "O número do cartãoSus precisa ser preenchido!")
    private String cartaoSus;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;
}
