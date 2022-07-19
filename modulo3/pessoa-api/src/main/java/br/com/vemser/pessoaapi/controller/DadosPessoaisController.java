package br.com.vemser.pessoaapi.controller;
import br.com.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.vemser.pessoaapi.service.DadosPessoaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    //read
    @GetMapping
    List<DadosPessoaisDTO> getListDadosPessoais() {
        return dadosPessoaisService.listarTodos();
    }

    //create
    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return ResponseEntity.ok(dadosPessoaisService.post(dadosPessoaisDTO));
    }


    //update
    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> update(@PathVariable("cpf") String cpf,
                                            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {

        return ResponseEntity.ok(dadosPessoaisService.put(cpf, dadosPessoaisDTO));
    }


    //delete
    @DeleteMapping("/{cpf}") // localhost:8080/pessoa/idPessoa
    public void delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisService.delete(cpf);
    }

}

/*
NOTAS:
Logs e validações são feitas através da api, responsabilidade da api que estamos utilizando.
Controller interage sempre através da service, não pode ser feita com Client.
Segue sempre o padrão de interagir através DA SERVICE.
*/