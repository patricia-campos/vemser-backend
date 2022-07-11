package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j //para usar log

public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping // Listar endereços - localhost:8080/endereco
    public List<Endereco> list() {
        return enderecoService.list();
    }


    @GetMapping("/{idEndereco}") // Listar endereço por id - localhost:8080/endereco/idEndereco
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(idEndereco);
    }


    @GetMapping("/{idPessoa}/pessoa") // Listar endereco por pessoa - localhost:8080/endereco/idPessoa/pessoa
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }


    @PostMapping("/{idPessoa}") // Criar novo endereço por idPessoa - localhost:8080/idPessoa
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco)
            throws Exception {
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }


    @PutMapping("/{idEndereco}") // Editar endereco existente (deve receber todos os dados) - localhost:8080/contato/idEndereco
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                           @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));
    }


    @DeleteMapping("/{idEndereco}") // Excluir endereco- localhost:8080/endereco/idEndereco
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}

/*
NOTAS DE ESTUDO:
Post e Put (entradas de dados) agora usam EnderecoDTO e EnderecoCreateDTO para fazer o tráfego de informações
*/