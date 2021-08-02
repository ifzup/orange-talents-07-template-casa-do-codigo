package br.com.zupacademy.iagofaria.casadocodigo.paisEEstado;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String nome;

    public Pais(@Valid PaisRequest paisForm) {
        this.nome = paisForm.getNome();
    }

    @Deprecated
    public Pais() {
    }
}
