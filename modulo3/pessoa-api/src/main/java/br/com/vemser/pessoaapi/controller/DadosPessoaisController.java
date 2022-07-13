package br.com.vemser.pessoaapi.controller;
import br.com.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisClient dadosPessoaisClient;

    @GetMapping
    List<DadosPessoaisDTO> getListPessoas() {
        return dadosPessoaisClient.getAll();
    }

    /*
    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<DadosPessoaisDTO> create(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return ResponseEntity.ok(dadosPessoaisClient.post(dadosPessoaisDTO));
    }

    @PutMapping("/{cpf}") // localhost:8080/pessoa/idPessoa
    public ResponseEntity<DadosPessoaisDTO> update(@PathVariable("cpf") String cpf,
                                            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {

        return ResponseEntity.ok(dadosPessoaisClient.put(cpf, dadosPessoaisDTO));
    }
*/
}
