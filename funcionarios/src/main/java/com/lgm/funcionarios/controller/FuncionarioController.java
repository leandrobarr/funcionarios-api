package com.lgm.funcionarios.controller;

import com.lgm.funcionarios.controller.dto.AtualizarFuncionarioRequest;
import com.lgm.funcionarios.controller.dto.IncluirFuncionarioRequest;
import com.lgm.funcionarios.controller.dto.IncluirFuncionarioResponse;
import com.lgm.funcionarios.model.Funcionario;
import com.lgm.funcionarios.service.FuncionarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final ObjectMapper mapper = new ObjectMapper();

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping()
    public ResponseEntity<List<Funcionario>> listar() {
        return new ResponseEntity<>(funcionarioService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Funcionario> ler(@PathVariable("id") Long id) {
        return new ResponseEntity<>(funcionarioService.getFuncionario(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<IncluirFuncionarioResponse> Incluir(@RequestParam String funcionarioData, @RequestParam("file")
    final MultipartFile file) throws IOException {

        final var incluirFuncionarioRequest = mapper.readValue(funcionarioData, IncluirFuncionarioRequest.class);
        incluirFuncionarioRequest.setFoto(file.getInputStream().readAllBytes());

        var funcionario = funcionarioService.incluir(incluirFuncionarioRequest);

        var funcionarioResponse = new IncluirFuncionarioResponse();
        BeanUtils.copyProperties(funcionario, funcionarioResponse);
        return  new ResponseEntity<>(funcionarioResponse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Funcionario> atualizar(@RequestParam String funcionarioData, @RequestParam(value = "file", required = false)
    final MultipartFile file) throws IOException {
        final var atualizarFuncionarioRequest = mapper.readValue(funcionarioData, AtualizarFuncionarioRequest.class);

        if (file != null) {
            atualizarFuncionarioRequest.setFoto(file.getInputStream().readAllBytes());
        }
        var funcionario = funcionarioService.atualizar(atualizarFuncionarioRequest);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        funcionarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
