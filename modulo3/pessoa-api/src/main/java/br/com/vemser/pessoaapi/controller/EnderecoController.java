package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    //1 - Recupera todos os endereços
    @GetMapping
    public List<Endereco> list() {return enderecoService.list();}

    //2 - Recupera endereçpo específico
    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(idEndereco);
    }

    //3 - Recupera endereco por idPessoa
    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    //4 - Cadastro de endereço por idPessoa
    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody Endereco endereco) throws Exception {
        return enderecoService.create(id, endereco);
    }

    //5 - Altera os dados do endereço
    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer id,
                           @Valid @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id, enderecoAtualizar);
    }

    //6 - Deleta por idEndereço
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

}
