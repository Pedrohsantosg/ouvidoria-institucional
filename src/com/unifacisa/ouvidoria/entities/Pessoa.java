package com.unifacisa.ouvidoria.entities;

public class Pessoa {
	private String nome;
    private String senha;
    
    public Pessoa(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public boolean autenticar(String nomeUsuario, String senha) {
        return nome.equals(nomeUsuario) && this.senha.equals(senha);
    }
}

