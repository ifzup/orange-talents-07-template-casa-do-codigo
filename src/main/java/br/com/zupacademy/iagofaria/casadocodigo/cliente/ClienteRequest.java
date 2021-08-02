package br.com.zupacademy.iagofaria.casadocodigo.cliente;


import br.com.zupacademy.iagofaria.casadocodigo.paisEEstado.Estado;
import br.com.zupacademy.iagofaria.casadocodigo.paisEEstado.Pais;
import br.com.zupacademy.iagofaria.casadocodigo.validator.CpfOuCnpj;
import br.com.zupacademy.iagofaria.casadocodigo.validator.FindObjectId;
import br.com.zupacademy.iagofaria.casadocodigo.validator.UniqueValue;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ClienteRequest {
    @Email
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CpfOuCnpj
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "cpf")
    private String cpf;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @FindObjectId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;
    private Long estadoId;
    @Size(min = 8, max = 12)
    private String telefone;
    @Size(min = 8, max = 8)
    private String cep;

    public ClienteRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
                          @CPF @NotBlank String cpf, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
                          @NotNull Long paisId, @NotNull Long estadoId, @Size(min = 8, max = 12) String telefone,
                          @Size(min = 8, max = 8) String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Cliente converte(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        Estado estado = null;
        if (estadoId != null) {
            estado = manager.find(Estado.class, estadoId);
        }

        return new Cliente(email, nome, sobrenome, cpf, endereco, complemento, cidade, pais, estado, telefone, cep);
    }


}
