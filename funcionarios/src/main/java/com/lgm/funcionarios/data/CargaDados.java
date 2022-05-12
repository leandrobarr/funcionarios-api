package com.lgm.funcionarios.data;


import com.lgm.funcionarios.dao.FuncionarioRepository;
import com.lgm.funcionarios.model.Funcionario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

@Component
public class CargaDados {

    @Value("${habilitar.carregar.massa.dados}")
    private boolean podeCarregarDados;

    private final FuncionarioRepository funcionarioRepository;

    public CargaDados(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostConstruct
    public void loadData() throws IOException {

        if (podeCarregarDados) {
            for (int x =1; x <= 8; x++) {

                var foto = getClass()
                        .getClassLoader()
                        .getResourceAsStream("funcionarios/avatar" + x + ".png")
                        .readAllBytes();

                var funcionario = new Funcionario();
                var nome = UUID.randomUUID().toString();
                funcionario.setId(Long.valueOf(x));
                funcionario.setNome(nome);
                String cidade = "";
                funcionario.setCidade(cidade);
                String uf = "";
                funcionario.setUf(uf);
                funcionario.setTelefone("93500-9798" + x);
                funcionario.setEmail(nome + "@lgm.com.br");
                funcionario.setFoto(foto);
                funcionario.setDataCadastro(Instant.now());
                funcionario.setUltimaAtualizacao(Instant.now());
                funcionarioRepository.save(funcionario);
            }
        }
    }
}
