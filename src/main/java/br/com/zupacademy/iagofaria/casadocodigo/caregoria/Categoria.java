package br.com.zupacademy.iagofaria.casadocodigo.caregoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    public Categoria(@NotBlank String nome) {
        if (nome.equals("") || nome.trim().equals("") || nome == null) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        this.nome = nome;
    }

    @Deprecated
    public Categoria() {
    }
}
