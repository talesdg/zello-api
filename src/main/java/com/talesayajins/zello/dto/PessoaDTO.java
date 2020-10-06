package com.talesayajins.zello.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.talesayajins.zello.entities.Pessoa;

public class PessoaDTO {
	
	private Integer id;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=50, message="O tamanho deve ser entre 5 e 50 caracteres")
	private String nome;
	
	@CPF(message="Número CPF inválido")
	private String cpf;
	
	private Date dt_nascimento;
	
	private String rg;
	
	private Integer perfil_id;
	
	public PessoaDTO() {
		
	}
	
	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		cpf = obj.getCpf();
		dt_nascimento = obj.getDt_nascimento();
		rg = obj.getRg();
		if(obj.getPerfil()!=null) {
			perfil_id = obj.getPerfil().getId();
		}
	}

	public PessoaDTO(String nome, String cpf, Date dt_nascimento, String rg, Integer perfil_id) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dt_nascimento = dt_nascimento;
		this.rg = rg;
		this.perfil_id = perfil_id;
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

	public Integer getPerfil_id() {
		return perfil_id;
	}

	public void setPerfil_id(Integer perfil_id) {
		this.perfil_id = perfil_id;
	}
	
	
}
