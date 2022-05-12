package com.lgm.funcionarios.model;


import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String nome;
    private String cidade;
    private String uf;
    private String telefone;
    @Column(unique = true)
    private String matricula;
    @Column(unique = true)
    private String email;
    @Lob
    private byte[] foto;
    private Instant dataCadastro;
    private Instant ultimaAtualizacao;
}
