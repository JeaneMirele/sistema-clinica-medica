package com.jeanemirele.UBS.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Medico extends Funcionario {
    private String crm;
    private String especialidade;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    @Override
    public boolean folgar(boolean escalado){
        return escalado = false;
    }
    @Override
    public double calcularSalario(Double salario){
        return salario + 2000;
    }
}

