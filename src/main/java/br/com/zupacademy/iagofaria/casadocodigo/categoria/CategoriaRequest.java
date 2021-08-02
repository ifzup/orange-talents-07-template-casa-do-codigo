package br.com.zupacademy.iagofaria.casadocodigo.categoria;

import br.com.zupacademy.iagofaria.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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

    public String getNome() {
        return nome;
    }
}
