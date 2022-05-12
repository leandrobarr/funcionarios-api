package com.lgm.funcionarios.controller.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class IncluirFuncionarioResponse {
    private Long id;
    private String nome;
    private String cidade;
    private String uf;
    private String telefone;
    private String matricula;
    private String email;
    private Instant dataCadastro;
    private Instant ultimaAtualizacao;
}
