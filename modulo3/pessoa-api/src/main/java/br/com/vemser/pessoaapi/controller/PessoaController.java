package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa

public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController() {
        pessoaService = new PessoaService();
    }

    // localhost:8080/pessoa/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    // localhost:8080/pessoa
    @GetMapping
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    // localhost:8080/pessoa/byname?nome=Rafa
    @GetMapping("/byname")
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    // localhost:8080/pessoa
    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.create(pessoa);
    }

    // localhost:8080/pessoa/1000
    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    // localhost:8080/pessoa/10
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}