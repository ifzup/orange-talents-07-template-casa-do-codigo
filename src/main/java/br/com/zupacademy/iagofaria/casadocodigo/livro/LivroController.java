package br.com.zupacademy.iagofaria.casadocodigo.livro;

import br.com.zupacademy.iagofaria.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.iagofaria.casadocodigo.caregoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<LivroResponse> listar(){
        List<Livro> listaDeLivros = livroRepository.findAll();

        //return listaDeLivros;
       return LivroResponse.converte(listaDeLivros);
    }
}
