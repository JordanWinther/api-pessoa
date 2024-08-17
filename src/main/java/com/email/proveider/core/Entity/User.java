package com.email.proveider.core.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "usuario")
public class User{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private Integer id;
	
	private String nome;
	private String idade;
	
	public User() {
		
	}
	
	
	public User( String nome, String idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public User( Integer id, String nome, String idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
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
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	

}

