package br.com.zupacademy.iagofaria.casadocodigo.paisEEstado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String nome;

    @ManyToOne
    @NotNull
    private Pais pais;

    public Estado(@NotBlank String nomeEstado, Pais paisDoEstado){
        this.nome = nomeEstado;
        this.pais = paisDoEstado;
    }

    @Deprecated
    public Estado(){}

}
