package br.com.zupacademy.iagofaria.casadocodigo.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class FindObjectIdValidator implements ConstraintValidator<FindObjectId, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(br.com.zupacademy.iagofaria.casadocodigo.validator.FindObjectId params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + "=:value");
        query.setParameter("value", (Long) value);
        List<?> list = query.getResultList();
        int tamanhoLista = list.size();
        Assert.state(tamanhoLista == 1, "Foram encontrados " + tamanhoLista + " registros de " + klass + " com o id " + value);
        return true;
    }

}