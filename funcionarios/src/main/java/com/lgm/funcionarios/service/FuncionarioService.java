package com.lgm.funcionarios.service;


import com.lgm.funcionarios.controller.dto.AtualizarFuncionarioRequest;
import com.lgm.funcionarios.controller.dto.IncluirFuncionarioRequest;
import com.lgm.funcionarios.dao.FuncionarioRepository;
import com.lgm.funcionarios.exception.FuncionarioNaoEncontradoException;
import com.lgm.funcionarios.model.Funcionario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getFuncionario(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionario não encontrado" + id));
    }

    public Funcionario incluir(IncluirFuncionarioRequest funcionarioRequest) {
        var data = Instant.now();

        var funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioRequest, funcionario);
        funcionario.setDataCadastro(data);
        funcionario.setUltimaAtualizacao(data);
        funcionarioRepository.save(funcionario);

        return funcionario;
    }

    public Funcionario atualizar(AtualizarFuncionarioRequest atualizarFuncionarioRequest) {
        var funcionario = funcionarioRepository.findById(atualizarFuncionarioRequest.getId()).get();

        BeanUtils.copyProperties(atualizarFuncionarioRequest, funcionario);
        funcionario.setUltimaAtualizacao(Instant.now());
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
