package br.com.zupacademy.iagofaria.casadocodigo.caregoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    private String nome;

    public CategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public CategoriaRequest() {
    }

    public Categoria criarCategoria() {
        return new Categoria(nome);
    }

    public String getNome(){
        return nome;
    }
}
