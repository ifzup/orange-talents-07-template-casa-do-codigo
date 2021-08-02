package br.com.zupacademy.iagofaria.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping()
    @Transactional
    public void cadastrar(@RequestBody @Valid AutorRequest autorForm) {
        Autor autor = autorForm.criarAutor();
        autorRepository.save(autor);
    }
}
