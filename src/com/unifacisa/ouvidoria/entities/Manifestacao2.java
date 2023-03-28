package com.unifacisa.ouvidoria.entities;

public class Manifestacao2 {
	private int id;
	private int tipo;
	private String assunto;
	private String descricao;

	public Manifestacao2(int id, int tipo, String assunto, String descricao) {
		this.id = id;
		this.tipo = tipo;
		this.assunto = assunto;
		this.descricao = descricao;
	}
	
	public String getAssunto() {
		return assunto;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Manifestacao \n id=" + id + "\n tipo=" + tipo + "\n assunto=" + assunto + "\n descricao=" + descricao;
	}
}
