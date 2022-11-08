package com.migrations.restaurante;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "tb_restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFantasia;

    @CNPJ
    @Column(length = 14)
    private String cnpj;

    private String endereco;

    private String bairro;

    private String cidade;

    @Column(length = 9)
    private String cep;

    private String telefone;

    private String celular;

    @Email
    private String email;

    private String site;

}
