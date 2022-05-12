package com.lgm.funcionarios.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncluirFuncionarioRequest {
    private Long id;
    private String nome;
    private String cidade;
    private String uf;
    private String telefone;
    private String matricula;
    private String email;
    private byte[] foto;
}
