package br.com.vemser.pessoaapi.controller;

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


    //=================================================================================================================
    //GET
    @GetMapping
    List<DadosPessoaisDTO> getListDadosPessoais() {
        return dadosPessoaisService.listarTodos();
    }


    //=================================================================================================================
    //POST
    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return ResponseEntity.ok(dadosPessoaisService.post(dadosPessoaisDTO));
    }


    //=================================================================================================================
    //PUT
    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> update(@PathVariable("cpfCliente") String cpf,
                                                   @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {

        return ResponseEntity.ok(dadosPessoaisService.put(cpf, dadosPessoaisDTO));
    }


    //=================================================================================================================
    //DELETE
    @DeleteMapping("/{cpf}") // localhost:8080/pessoa/idPessoa
    public void delete(@PathVariable("cpfCliente") String cpf) {
        dadosPessoaisService.delete(cpf);
    }

}
    //=================================================================================================================

/*
NOTAS:
Logs e valida????es s??o feitas atrav??s da api, responsabilidade da api que estamos utilizando.
Controller interage sempre atrav??s da service, n??o pode ser feita com Client.
Segue sempre o padr??o de interagir atrav??s DA SERVICE.
*/