package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "medicamentos")

public class Medicamento {

    public Medicamento() {}

    public Medicamento(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O nome não pode ser vazio!")
    private String name;

    @NotBlank(message = "O tipo não pode ser vazio!")
    private String tipo;

    @NotBlank(message = "A marca não pode ser vazio!")
    private String marca;

    @NotBlank(message = "A quantidade não pode ser vazio!")
    private String quantidade;

    @OneToOne(optional = false)
    private Farmacia farmacia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    
}
