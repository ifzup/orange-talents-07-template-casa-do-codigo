package br.com.zupacademy.iagofaria.casadocodigo.livro;

import br.com.zupacademy.iagofaria.casadocodigo.autor.Autor;
import br.com.zupacademy.iagofaria.casadocodigo.caregoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotBlank
    @Size(min = 20)
    private BigDecimal preco;

    @NotBlank
    @Size(min = 100)
    private int numeroPaginas;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @NotNull
    //@Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull
    @ManyToOne
    private String categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotBlank @Size(min = 20) BigDecimal preco, @NotNull @Min(100) int numeroPaginas, @NotBlank String isbn, @NotNull @Future LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
    }


}