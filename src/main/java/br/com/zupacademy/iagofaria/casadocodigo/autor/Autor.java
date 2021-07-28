package br.com.zupacademy.iagofaria.casadocodigo.autor;

import br.com.zupacademy.iagofaria.casadocodigo.validator.UniqueValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataDoRegistro = LocalDateTime.now();

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

    public Autor(Long id, LocalDateTime dataDoRegistro, String email, String nome, String descricao) {
        this.id = id;
        this.dataDoRegistro = dataDoRegistro;
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Deprecated
    public Autor(@Email @NotBlank String email, @NotBlank String nome, @NotBlank @Size(max = 400) String descricao) {
    }


}
