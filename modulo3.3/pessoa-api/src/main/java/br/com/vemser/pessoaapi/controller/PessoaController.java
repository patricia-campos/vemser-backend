package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PageDTO;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.RelatorioPersonalizadoDTO;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.service.EmailService;
import br.com.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private PessoaRepository pessoaRepository;


    @Value("${user}")
    private String usuario;
    @Value("${spring.application.name}")
    private String app;


    //==================================================================================================================
    //                                                GET / READ
    //==================================================================================================================

    @Operation(summary = "Listar clientes cadastrados", description = "Lista todos os clientes cadastrados no banco")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de clientes"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    //=================================================================================================================


    @Operation(summary = "Listar clientes cadastrados por nome",
            description = "Lista todos os clientes cadastrados no banco utilizando o nome como parâmetro dessa busca")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna clientes com o nome solicitado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    //=================================================================================================================


    @Operation(summary = "Retornar cliente cadastrado por id",
            description = "Retorna cliente cadastrado no banco utilizando o id como parâmetro dessa busca")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna cliente com o id solicitado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}") // localhost:8080/pessoa/idPessoa
    public List<PessoaDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return pessoaService.listByIdPessoa(idPessoa);
    }

    //=================================================================================================================

    @Operation(summary = "Retornar cliente cadastrado por cpf",
            description = "Retorna cliente cadastrado no banco utilizando o cpf como parâmetro dessa busca")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna cliente com o cpf solicitado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/by-cpf")

    public ResponseEntity<List<PessoaDTO>> list(@RequestParam("cpf") String cpf) {
        return ResponseEntity.ok(pessoaService.findByCpf(cpf));
    }

    //=================================================================================================================

    @Operation(summary = "Retornar cliente cadastrado com contato",
            description = "Retorna cliente cadastrado no banco ucom seus contatos")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna cliente com seus contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/listar-com-contato")

    public ResponseEntity<List<PessoaDTO>> listPessoaComContato(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listarPessoaEContato(), HttpStatus.OK);
    }

    //=================================================================================================================

    @Operation(summary = "Retornar cliente cadastrado com endereço",
            description = "Retorna cliente cadastrado no banco com seus endereços")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna cliente com endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/listar-com-enderecos")

    public ResponseEntity<List<PessoaDTO>> listPessoaComEnderecos(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listarPessoaEEndereco(), HttpStatus.OK);
    }

    //=================================================================================================================

    @Operation(summary = "Retornar cliente cadastrado com pet",
            description = "Retorna cliente cadastrado com seus pets")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna cliente com o pet"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/listar-com-pets")
    public ResponseEntity<List<PessoaDTO>> listPessoaComPets(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listarPessoaEPets(), HttpStatus.OK);
    }

    //==================================================================================================================
    //                                               POST / CREATE
    //==================================================================================================================

    @Operation(summary = "Inserir novo cliente no sistema",
            description = "Insere um novo cliente no cadastro do sistema")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cadastra um novo cliente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    //==================================================================================================================
    //                                                PUT / UPDATE
    //==================================================================================================================

    @Operation(summary = "Alterar dados de cliente cadastrado",
            description = "Altera os dados de um cliente cadastrado no sistema, utilizando o id do cliente " +
                    "como parâmetro para efetuar a alteração")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Altera dados cadastrais do cliente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/idPessoa
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {

        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    //==================================================================================================================
    //                                                 DELETE
    //==================================================================================================================

    @Operation(summary = "Excluir cliente cadastrado",
            description = "Exclui um cliente cadastrado no sistema, utilizando o id do cliente como " +
                    "parâmetro para efetuar a exclusão")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Exclui cliente cadastrado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/idPessoa
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }

    //==================================================================================================================
    //                                                 GET HOMEWORK
    //==================================================================================================================

    @Operation(summary = "Relatório personalizado",
            description = "Exibe relatório personalizado")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Relatório personalizado exibido"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )


    @GetMapping("/relatorio-personalizado")
    public PageDTO<RelatorioPersonalizadoDTO> getRelatorioPersonalizado(@RequestParam(required = false) Integer idPessoa, Integer pagina, Integer quantidadeRegistros) {
        //return pessoaRepository.relatorioPersonalizadoDTO(idPessoa);
        return pessoaService.relatorioPersonalizadoDTO(idPessoa, pagina, quantidadeRegistros);
    }


    //------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Pessoa Completo",
            description = "Exibe pessoa completo")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Relatório pessoa completo"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/pessoa-completo")
    public ResponseEntity<List<PessoaDTO>> listPessoaCompleto(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaCompleto(idPessoa), HttpStatus.OK);
    }

    //=================================================================================================================


    //}


}



    /*
      NOTAS DE ESTUDO: //TODO REIMPLEMENTAR EMAIL

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