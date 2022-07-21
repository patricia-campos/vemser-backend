package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /*
    //FEITO EM AULA
    @GetMapping("/endereco-por-pais")
    public ResponseEntity<EnderecoEntity> getEnderecoPorPais(@RequestParam Integer idPessoa) {
        return new ResponseEntity<>(enderecoByIdPessoa(idPessoa), HttpStatus.ok);
    }
    */



    //=================================================================================================================


    @Operation(summary = "Listar endereços cadastrados",
            description = "Lista todos os endereços cadastrados no banco")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços cadastrados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping // localhost:8080/endereco
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }


    //=================================================================================================================


    @Operation(summary = "Mostrar endereço específico cadastrado",
            description = "Lista endereço cadastrado no banco utilizando o id do endereço como " +
                    "parâmetro da busca")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna endereço cadastrado por id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}") // localhost:8080/endereco/idEndereco
    public List<EnderecoDTO> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(idEndereco);
    }


    //=================================================================================================================

/*
    @Operation(summary = "Listar endereços cadastrado de cliente",
               description = "Lista endereços cadastrados de cliente, utilizando o id do cliente como " +
                             "parâmetro da busca")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna endereço cadastrado do cliente por id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/{idPessoa}/pessoa") // localhost:8080/endereco/idPessoa/pessoa
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

*/
    //=================================================================================================================


    @Operation(summary = "Inserir novo endereço no cadastro do cliente",
            description = "Insere um novo endereço no cadastro do cliente, utilizando o id do cliente como " +
                    "parâmetro para este cadastro")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Insere um novo endereço no cadastro do cliente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PostMapping("/{idPessoa}") // localhost:8080/endereco/idPessoa
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco)
            throws Exception {
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }


    //=================================================================================================================


    @Operation(summary = "Alterar endereço no cadastro do cliente",
            description = "Altera endereço no cadastro do cliente, utilizando o id do endereço a ser editado como " +
                    "parâmetro para efetuar a alteração")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita endereço no cadastro do cliente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PutMapping("/{idEndereco}") // localhost:8080/endereco/idEndereco
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                                              @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));
    }


    //=================================================================================================================


    @Operation(summary = "Excluir endereço cadastrado",
            description = "Exclui endereço de cliente cadastrado no sistema, utilizando o id do endereço como " +
                    "parâmetro para efetuar a exclusão")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Exclui endereço cadastrado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @DeleteMapping("/{idEndereco}") // localhost:8080/endereco/idEndereco
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }


    //=================================================================================================================
}

/*
NOTAS DE ESTUDO:
Post e Put (entradas de dados) agora usam EnderecoDTO e EnderecoCreateDTO para fazer o tráfego de informações
*/