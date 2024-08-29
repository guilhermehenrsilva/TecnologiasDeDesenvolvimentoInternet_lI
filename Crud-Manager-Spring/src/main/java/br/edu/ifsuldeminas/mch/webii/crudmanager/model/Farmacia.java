package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "farmacias")
public class Farmacia {

    public Farmacia() {}

    public Farmacia(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;   

    @NotBlank(message = "CNPJ é obrigatório!")
    private String cnpj;

    @NotBlank(message = "Endereco é obrigatório!")
    private String endereco;

    @NotBlank(message = "Cidade é obrigatório!")
    private String cidade;

    @OneToMany(mappedBy = "farmacia")
    private List<Medicamento> medicamentos;
}
