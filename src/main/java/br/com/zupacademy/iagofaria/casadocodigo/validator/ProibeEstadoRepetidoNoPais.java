package br.com.zupacademy.iagofaria.casadocodigo.validator;

import br.com.zupacademy.iagofaria.casadocodigo.paisEEstado.Estado;
import br.com.zupacademy.iagofaria.casadocodigo.paisEEstado.EstadoRepository;
import br.com.zupacademy.iagofaria.casadocodigo.paisEEstado.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Component
public class ProibeEstadoRepetidoNoPais implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        EstadoRequest form = (EstadoRequest) target;

        Optional<Estado> possivelEstado = estadoRepository.findByNomeAndPaisId(form.getNome(), form.getPaisId());

        if (possivelEstado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            // errors.rejectValue("paisId", null, "Pais Id:" + form.getPaisId() + " já possui o estado " + form.getNome() + " cadastrado!");
        }
    }


}
