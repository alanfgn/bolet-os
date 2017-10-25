package br.com.alan.boletos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
@PrimaryKeyJoinColumn(name = "id")
public class Usuario extends Pessoa {

	@NotBlank
	@Column(unique = true, nullable = false)
	private String nome;

	@NotBlank
	@Column(unique = true, nullable = false)
	private String email;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
