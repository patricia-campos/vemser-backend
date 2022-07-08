package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.service.PessoaService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
@Slf4j //para usar log

public class PessoaController {

    @Autowired //sempre acima do atributo
    private PessoaService pessoaService;

    @Value("${user}")
    private String usuario;

    @Value("${spring.application.name}")
    private String app;


    // localhost:8080/pessoa/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello world!" + app;
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
    //aula 07/07 e 08/07
    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody @Valid  Pessoa pessoa) {

        //ALTERADO AULA 08/07
        return ResponseEntity.ok(pessoaService.create(pessoa));

        //log.info("Criando pessoa...");
        // Pessoa p = pessoaService.create(pessoa);
        //log.info("Pessoa " + p.getNome() + " criada!");
        //return ResponseEntity.ok(p);
        //return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    // localhost:8080/pessoa/1000
    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    // localhost:8080/pessoa/10
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}