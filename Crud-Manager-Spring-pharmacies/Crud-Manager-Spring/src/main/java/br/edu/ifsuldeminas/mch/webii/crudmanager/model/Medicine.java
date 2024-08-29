package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "O nome do medicamento não pode ser vazio!")
	@Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome não pode conter números ou caracteres especiais")
	private String nome;
	
	
	@NotBlank(message = "O tipo do medicamento não pode ser vazio!")
	@Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome não pode conter números ou caracteres especiais")
	private String tipo;
	
	@NotBlank(message = "O nome da marca do medicamento não pode ser vazio!")
	@Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome não pode conter números ou caracteres especiais")
	private String marca;

	@NotBlank(message = "A quantidade não pode ser vazio!")
	private String quantidade;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "pharmacy_id")
	private Pharmacy pharmacy;

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	
	public Medicine() {}
	
	public Medicine(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	
	
}
