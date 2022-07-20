package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.service.PetService;
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
@RequestMapping("/pet")
@Validated
@Slf4j //para usar log
public class PetController {

    @Autowired
    private PetService petService;

    //=================================================================================================================


    @Operation(summary = "Listar pets",
            description = "Lista pets cadastrados")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna pets cadastrados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping
    public List<PetDTO> list() {
        return petService.list();
    }


    //=================================================================================================================


    @Operation(summary = "Inserir novo pet",
            description = "Insere novo pet no cadastro")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Insere pet no cadastro"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}") // localhost:8080/contato/idPessoa
    public ResponseEntity<PetDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody PetCreateDTO pet)
            throws Exception {
        return ResponseEntity.ok(petService.create(id, pet));
    }


    //=================================================================================================================


    @Operation(summary = "Alterar dados pet",
            description = "Altera os dados de pet cadastrado")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Altera dados de pet"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PutMapping("/{idPet}") // (deve receber todos os dados)
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") Integer id,
                                             @Valid @RequestBody PetCreateDTO petAtualizar) throws Exception {
        return ResponseEntity.ok(petService.update(id, petAtualizar));
    }


    //=================================================================================================================


    @Operation(summary = "Excluir pet",
            description = "Exclui pet")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Exclui pet cadastrado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer id) throws Exception {
        petService.delete(id);
    }


    //=================================================================================================================
}
