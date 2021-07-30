package br.com.zupacademy.iagofaria.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private String titulo;
    private Long id;

    @Deprecated
    public LivroResponse(){}

    public LivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.id = livro.getId();
    }

    public static List<LivroResponse> converte(List<Livro> listaDeLivros) {
        return listaDeLivros.stream().map(LivroResponse::new).collect(Collectors.toList());
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }
}
