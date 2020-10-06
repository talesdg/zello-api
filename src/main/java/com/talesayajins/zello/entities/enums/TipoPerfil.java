package com.talesayajins.zello.entities.enums;

public enum TipoPerfil {

	COMUM(1,"Comum"),
	GESTOR(2,"Gestor"),
	ADMIN(3,"Administrador");

	private int cod;
	private String descricao;
	
	private TipoPerfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPerfil toEnum(Integer cod) {
		if( cod == null) {
			return null;
		}
		for(TipoPerfil t : TipoPerfil.values()) {
			if(cod.equals(t.getCod())) {
				return t;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
	
	
}
