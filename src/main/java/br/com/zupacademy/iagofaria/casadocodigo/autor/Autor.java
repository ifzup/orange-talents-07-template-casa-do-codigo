package br.com.zupacademy.iagofaria.casadocodigo.autor;

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

    public Autor(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Autor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Deprecated
    public Autor() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
