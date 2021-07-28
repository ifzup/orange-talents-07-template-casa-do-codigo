package br.com.zupacademy.iagofaria.casadocodigo.autor;

import br.com.zupacademy.iagofaria.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class AutorRequest {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest(@Email @NotBlank String email,
                        @NotBlank String nome,
                        @NotBlank @Size(min = 1, max = 400) String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Autor criarAutor() {
        return new Autor(email, nome, descricao);
    }
}
