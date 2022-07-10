package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.service.ContatoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contato")
@Validated
@Slf4j //para usar log

public class ContatoController {

    @Autowired
    private ContatoService contatoService;


    @GetMapping // Listar contatos - localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }


    @GetMapping("/{idPessoa}") // Listar por pessoa - localhost:8080/contato/idPessoa
    public List<Contato> listByIdCliente(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    /*
    @PostMapping("/{idPessoa}") // Criar novo contato em pessoa existente - localhost:8080/contato/idPessoa
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody Contato contato)
            throws Exception {
        return ResponseEntity.ok(contatoService.create(id, contato));
    }
    */

    @PostMapping("/{idPessoa}") // Criar novo contato em pessoa existente - localhost:8080/contato/idPessoa
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody ContatoCreateDTO contato)
            throws Exception {
        return ResponseEntity.ok(contatoService.create(id, contato));
    }

    @PutMapping("/{idContato}") // Editar contato existente (deve receber todos os dados) - localhost:8080/contato/idContato
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                          @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }


    @DeleteMapping("/{idContato}") // Excluir contato - localhost:8080/contato/idContato
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
