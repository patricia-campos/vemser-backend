package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")

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
    public Endereco create(@PathVariable("idPessoa") Integer id, @RequestBody Endereco endereco) throws Exception {
        return enderecoService.create(id, endereco);
    }

    //5 - Altera os dados do endereço
    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer id,
                          @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id, enderecoAtualizar);
    }

    //6 - Deleta por idEndereço
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }





}
