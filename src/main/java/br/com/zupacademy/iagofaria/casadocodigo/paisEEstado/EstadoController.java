package br.com.zupacademy.iagofaria.casadocodigo.paisEEstado;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @PersistenceContext
    EntityManager manager;

    @Autowired
    private ProibeEstadoRepetidoNoPais proibeEstadoRepetidoNoPais;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEstadoRepetidoNoPais);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid EstadoRequest estadoForm){
        Estado estado = estadoForm.converte(manager);
        estadoRepository.save(estado);
    }
}
