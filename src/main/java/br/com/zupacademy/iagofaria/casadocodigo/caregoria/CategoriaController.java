package br.com.zupacademy.iagofaria.casadocodigo.caregoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid CategoriaRequest categoriaForm){
        Categoria categoria = categoriaForm.criarCategoria();
        categoriaRepository.save(categoria);
    }
}
