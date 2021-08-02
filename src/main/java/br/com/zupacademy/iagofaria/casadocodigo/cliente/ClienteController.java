package br.com.zupacademy.iagofaria.casadocodigo.cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    ClienteRepository ClienteRep;

    @PersistenceContext
    EntityManager manager;

    @Autowired
    private VerificaSePaisTemEstado verificaSePaisTemEstado;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(verificaSePaisTemEstado);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid ClienteRequest clienteForm) {
        Cliente cliente = clienteForm.converte(manager);
        ClienteRep.save(cliente);
    }

}
