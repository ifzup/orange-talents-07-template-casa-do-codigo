package br.com.zupacademy.iagofaria.casadocodigo.livro;

import br.com.zupacademy.iagofaria.casadocodigo.autor.Autor;
import br.com.zupacademy.iagofaria.casadocodigo.categoria.Categoria;
import br.com.zupacademy.iagofaria.casadocodigo.validator.FindObjectId;
import br.com.zupacademy.iagofaria.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {


    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
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
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull
    @FindObjectId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    @NotNull
    @FindObjectId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        //this.dataDePublicacao = dataDePublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Livro converter(EntityManager manager) {
        Autor autor = manager.find(Autor.class, autorId);
        Categoria categoria = manager.find(Categoria.class, categoriaId);
        Assert.notNull(autor, "Autor não encontrado");
        Assert.notNull(categoria, "Categoria não encontrada");
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataDePublicacao, categoria, autor);
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataDePublicacao = dataPublicacao;
    }
}
