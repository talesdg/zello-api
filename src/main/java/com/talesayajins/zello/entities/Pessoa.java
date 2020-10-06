package com.talesayajins.zello.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column(unique=true)
	private String cpf;
	
	private Date dt_nascimento;
	
	private String rg;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="perfil_id")
	private Perfil perfil;
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id, String nome, String cpf, Date dt_nascimento, String rg, Perfil perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dt_nascimento = dt_nascimento;
		this.rg = rg;
		this.perfil = perfil;
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

//	public int getId_perfil() {
//		return id_perfil;
//	}
//
//	public void setId_perfil(int id_perfil) {
//		this.id_perfil = id_perfil;
//	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	};
	
	

}
