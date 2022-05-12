package com.lgm.funcionarios.dao;

import com.lgm.funcionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    List<Funcionario> findAll();
}
