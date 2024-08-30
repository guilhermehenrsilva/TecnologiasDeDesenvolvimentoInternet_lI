package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Pharmacy")
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "O nome da Farmacia não pode ser vazio!")
	private String nome;
	
	@NotBlank(message = "O CNPJ não pode estar vazio!")
	private String cnpj;

	@NotBlank(message = "O endereço da Farmacia não pode ser vazio!")
	private String endereco;
	
		
	@NotBlank(message = "O nome da cidade não pode ser vazio!")
	@Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome da cidade não pode conter números ou caracteres especiais")
	private String cidade;
	
	@NotBlank(message = "O e-mail da farmacia não pode ser vazio!")
	@Email(message = "E-mail inválido!")
	private String email;
	
	@OneToMany(mappedBy = "pharmacy")
	private List <Medicine> medicines;
	
	public Pharmacy() {}
	
	public Pharmacy(Integer id) {
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public List<Medicine> getMedicine() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
}
