package br.com.zupacademy.iagofaria.casadocodigo.paisEEstado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PaisRequest paisForm){
        Pais pais = new Pais(paisForm);
        paisRepository.save(pais);
    }
}
