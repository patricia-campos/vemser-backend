package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contato")

public class ContatoController {

    private ContatoService contatoService;

    public ContatoController() {contatoService = new ContatoService();}

    // Listar todos os contatos - GET
    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    // Listar por pessoa - GET
    @GetMapping("/byidpessoa")
    public List<Contato> listByIdPessoa(@RequestParam("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    // POST com um id da pessoa para adicionar o contato e no corpo, receber o contato para inserir
    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    // PUT com o id do contato, deve atualizar um contato existente e receber no corpo da requisição
    // os novos dados do contato (deve receber todos os dados)
    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    // Deve receber um id do contato e remover da lista
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
