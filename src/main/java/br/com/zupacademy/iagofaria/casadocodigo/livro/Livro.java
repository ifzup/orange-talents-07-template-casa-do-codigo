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

    @NotNull
    @Min(value = 20)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private int numeroPaginas;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @NotNull
    //@Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private @NotNull Categoria categoria;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    /*public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                 @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroPaginas, @NotBlank String isbn,
                 @NotNull LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }*/

}
