package br.com.zupacademy.iagofaria.casadocodigo.livro;

import br.com.zupacademy.iagofaria.casadocodigo.autor.Autor;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalhesResponse {

    private Long id;
    private String titulo;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private int numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Autor autor;



    public LivroDetalhesResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.numeroPaginas= livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataDePublicacao();
        this.autor = livro.getAutor();
    }

    @Deprecated
    public LivroDetalhesResponse() {
    }

    public Long getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }


    public BigDecimal getPreco() {
        return preco;
    }


    public String getResumo() {
        return resumo;
    }


    public String getSumario() {
        return sumario;
    }


    public int getNumeroPaginas() {
        return numeroPaginas;
    }


    public String getIsbn() {
        return isbn;
    }


    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }


    public Autor getAutor() {
        return autor;
    }
}
