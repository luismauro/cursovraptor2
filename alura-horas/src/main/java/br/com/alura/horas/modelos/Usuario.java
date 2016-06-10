package br.com.alura.horas.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

// como o usuario esta sendo guardado na classe Serializable UsuarioLogado, precissa ser implementa a interface nele
@Entity
public class Usuario implements Serializable {

	@Id
	@SequenceGenerator(name="usuario_idusuario_seq",
    sequenceName="usuario_idusuario_seq",
    allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator="usuario_idusuario_seq")
	private int id;
	
	@NotNull(message="Nao pode ser nulo") @NotEmpty(message="Nao pode ser vazio")
	private String nome;
					
	@NotNull(message="Nao pode ser nulo") @NotEmpty(message="Nao pode ser vazio")
	private String login;
	
	@NotNull(message="Nao pode ser nulo") @NotEmpty(message="Nao pode ser vazio")
	private String senha;
	
	@NotNull(message="Nao pode ser nulo") @NotEmpty(message="Nao pode ser vazio")
	@Email
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
