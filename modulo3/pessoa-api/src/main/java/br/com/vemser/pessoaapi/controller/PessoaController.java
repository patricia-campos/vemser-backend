package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
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



    @GetMapping // Listar pessoas - localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }


    @GetMapping("/byname") // Listar por nome - localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    /*
    @PostMapping // Criar nova pessoa - localhost:8080/pessoa
    public ResponseEntity<Pessoa> create(@RequestBody @Valid  Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }
     */


    /*
    @PutMapping("/{idPessoa}") // Editar pessoa existente - localhost:8080/pessoa/idPessoa
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {

        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }
    */


    //TODO - DTO POST E PUT EM CONSTRUÇÃO - INÍCIO -----------------------------------------------------
    @PostMapping // Criar nova pessoa - localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }


    @PutMapping("/{idPessoa}") // Editar pessoa existente - localhost:8080/pessoa/idPessoa
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {

        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    //TODO - DTO POST E PUT EM CONSTRUÇÃO - FIM -----------------------------------------------------


    @DeleteMapping("/{idPessoa}") // Excluir pessoa - localhost:8080/pessoa/idPessoa
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}





// localhost:8080/pessoa/hello
// @GetMapping("/hello")
//public String hello() {
//    return "Hello world!" + app;
//}
