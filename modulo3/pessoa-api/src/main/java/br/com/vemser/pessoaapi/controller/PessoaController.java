package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EmailService;
import br.com.vemser.pessoaapi.service.PessoaService;
import br.com.vemser.pessoaapi.repository.PessoaRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.SneakyThrows;
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
    @Autowired
    private EmailService emailService;

    @Value("${user}")
    private String usuario;
    @Value("${spring.application.name}")
    private String app;


    //========================EM AULA 12/07=======================================
    @Operation(summary = "Listar clientes cadastrados", description = "Lista todos os clientes cadastrados no banco")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de clientes"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                    }
                )

    @GetMapping // Listar pessoas - localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }


    //=================================================================================================================
    @Operation(summary = "Listar clientes cadastrados por nome",
               description = "Lista todos os clientes cadastrados no banco utilizando o nome como parâmetro de busca")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna clientes com o nome solicitado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/byname") // Listar por nome - localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    //=================================================================================================================
    @Operation(summary = "Listar clientes cadastrados por id",
               description = "Lista todos os clientes cadastrados no banco utilizando o id como parâmetro de busca")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna clientes com o id solicitado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}") // Listar por pessoa - localhost:8080/pessoa/idPessoa
    public List<Pessoa> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return pessoaService.listByIdPessoa(idPessoa);
    }
    //=================================================================================================================
    @Operation(summary = "Insere novo cliente no sistema",
               description = "Insere um novo cliente no cadastro do sistema")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cadastra um novo cliente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // Criar nova pessoa - localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }
    //=================================================================================================================
    @Operation(summary = "Altera dados de cliente cadastrado",
                description = "Altera os dados de um cliente cadastrado no sistema, utilizando o id do cliente como parâmetro para a alteração")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Altera dados do cliente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // Editar pessoa existente - localhost:8080/pessoa/idPessoa
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {

        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    //=================================================================================================================
    @Operation(summary = "Exclui cliente cadastrado",
            description = "Exclui um cliente cadastrado no sistema, utilizando o id do cliente como parâmetro para a alteração")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Exclui cliente cadastrado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") // Excluir pessoa - localhost:8080/pessoa/idPessoa
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }
}


    /*-----------------------------------------------------
    @SneakyThrows
    @GetMapping("/email")
    public String email() {
        //emailService.sendSimpleMessage();
        //emailService.sendWithAttachment();
        emailService.sendEmail();
        return "Enviando E-mail.. " + app + "!";
    }
    -----------------------------------------------------*/

    /*-----------------------------------------------------
    NOTAS DE ESTUDO:

    - Post e Put (entradas de dados) agora usam PessoaDTO e PessoaCreateDTO para fazer o tráfego de informações


    // localhost:8080/pessoa/hello
    // @GetMapping("/hello")
    //public String hello() {
    //    return "Hello world!" + app;
    //}

    -----------------------------------------------------*/