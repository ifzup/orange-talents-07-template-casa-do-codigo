package br.com.zupacademy.iagofaria.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesResponse> listarPorId(@PathVariable long id) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        if (livroOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new LivroDetalhesResponse(livroOpt.get()));
    }

}
