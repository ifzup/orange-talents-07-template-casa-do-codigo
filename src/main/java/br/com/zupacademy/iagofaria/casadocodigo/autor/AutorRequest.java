package br.com.zupacademy.iagofaria.casadocodigo.autor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class AutorRequest {

    @Email
    @NotBlank
    //@UniqueValue(domainClass = Autor.class, fieldName = "email")
    @Column(unique = true)
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
        Autor autorCriado = new Autor(email, nome, descricao);
        return autorCriado;
    }
}
