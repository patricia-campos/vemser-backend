package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.dto.PageDTO;
import br.com.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    //=================================================================================================================
    //GET

    @Operation(summary = "Listar todos os contatos de clientes",
            description = "Lista todos os contatos dos clientes cadastrados no banco")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos cadastrados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping // localhost:8080/contato
    public PageDTO<ContatoDTO> list(Integer pagina, Integer quantidadeRegistros) {

        return contatoService.list(pagina, quantidadeRegistros);
    }


    //@GetMapping // localhost:8080/contato
    //public List<ContatoDTO> list() {
    //    return contatoService.list();
    //}



    //------------------------------------------------------------------------------------------------------------------
    //GET POR ID

    /*
    @Operation(summary = "Listar contatos cadastrados por cliente",
            description = "Lista todos os contatos cadastrados por cliente, " +
                    "utilizando como parâmetro para essa busca o id do cliente")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos dos clientes por id do cliente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}") // localhost:8080/contato/idPessoa
    public List<ContatoDTO> listByIdCliente(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }
    */

    //=================================================================================================================
    //POST

    @Operation(summary = "Inserir novo contato em cliente cadastrado",
            description = "Insere novo contato no cadastro do cliente, utilizando id do cliente como parâmetro " +
                    "para este cadastro")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Insere novo contato em cliente cadastrado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}") // localhost:8080/contato/idPessoa
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody ContatoCreateDTO contato)
            throws Exception {
        return ResponseEntity.ok(contatoService.create(id, contato));
    }


    //=================================================================================================================
    //PUT

    @Operation(summary = "Alterar dados de contato de cliente cadastrado",
            description = "Altera os dados de contato de cliente cadastrado no sistema, " +
                    "utilizando o id do contato como parâmetro para a alteração")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Altera dados de contato de cliente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PutMapping("/{idContato}") // (deve receber todos os dados) - localhost:8080/contato/idContato
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }


    //=================================================================================================================
    //DELETE

    @Operation(summary = "Excluir contato de cliente cadastrado",
            description = "Exclui contato de cliente cadastrado no sistema, utilizando o id do contato como " +
                    "parâmetro para a exclusão")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Exclui contato cadastrado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}") // Excluir contato - localhost:8080/contato/idContato
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }


    //=================================================================================================================
}

/*
NOTAS DE ESTUDO:
Post e Put (entradas de dados) agora usam ContatoDTO e ContatoCreateDTO para fazer o tráfego de informações
*/

