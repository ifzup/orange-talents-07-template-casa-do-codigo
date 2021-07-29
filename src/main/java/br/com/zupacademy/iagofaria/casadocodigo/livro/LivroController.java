package br.com.zupacademy.iagofaria.casadocodigo.livro;

import br.com.zupacademy.iagofaria.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.iagofaria.casadocodigo.caregoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;


    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid LivroRequest form) {
        Livro livro = form.converter(manager);
        livroRepository.save(livro);
    }
}
