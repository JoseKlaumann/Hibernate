package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author José Augusto Klaumann
 * @version 1.0
 */
@Entity
@Table( name = "tb_contato")
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_increment do MySql
	private Long   id;
    private String nome;
	private String email;
	private String celular;

	/**
	 * @return id do contato
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id codigo gerado automaticamente pelo db
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return nome do contato
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome do contato informado
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return email do contato
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email do contato informado
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return calular do contato
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular do contato informado
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Contato: Id = " + id + ", Nome = " + nome + ", Email = " + email + ", Celular = " + celular;
	}
	
	
}
