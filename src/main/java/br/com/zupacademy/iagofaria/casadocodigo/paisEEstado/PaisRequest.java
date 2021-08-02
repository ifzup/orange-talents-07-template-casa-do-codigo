package br.com.zupacademy.iagofaria.casadocodigo.paisEEstado;

import br.com.zupacademy.iagofaria.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public PaisRequest() {
    }

    public String getNome(){
        return nome;
    }
}
