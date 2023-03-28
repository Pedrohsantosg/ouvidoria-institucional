package com.unifacisa.ouvidoria.entities;

import java.util.ArrayList;

public class Aluno extends Pessoa {
	
	private ArrayList<Manifestacao2> manifestacoes;

    public Aluno(String nome, String senha) {
        super(nome, senha);
        manifestacoes = new ArrayList<>();
    }

    public void cadastrarManifestacao(Manifestacao2 novaManifestacao) {
    	manifestacoes.add(novaManifestacao);
	}
    
    public void exibirManifestacoes() {
        for (Manifestacao2 manifestacao : manifestacoes) {
            System.out.println(manifestacao.toString());
        }
    }

	public void resetManifestacoes() {
		this.manifestacoes.clear();
	}

	public boolean deletarManifestacao(int id) {
		boolean saida = false;
		for (Manifestacao2 manifestacao : manifestacoes) {
			if (manifestacao.getId() == id) {
				saida = manifestacoes.remove(manifestacao);
				if (saida == true) {
					return saida;
				}
			}
		}
		return saida;
	}
}
