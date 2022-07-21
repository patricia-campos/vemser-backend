package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Slf4j //PARA USAR O LOG
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;


    //------------------------------------------------------------------------------------------------------------------
    //CREATE
    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoDTO) throws RegraDeNegocioException{


        //COLOCAR O COMMENT
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoDTO, EnderecoEntity.class);

        //Recuperou a pessoa que busquei através da service, com o parâmetro id
        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(idPessoa);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);

        log.info("Adicionando endereço...");

        EnderecoEntity enderecoEntity1 = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO1 = objectMapper.convertValue(enderecoEntity1, EnderecoDTO.class);

        return enderecoDTO1;

        //todo puxar os métodos dto acima - tá funcionando como está
    }

    //------------------------------------------------------------------------------------------------------------------
    //READ
    //lista todos os endereços
    public List<EnderecoDTO> list(){
        return enderecoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    /* //todo está inoperante

    //lista por id endereco
    public List<EnderecoDTO> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.findAll().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //todo está inoperante

    lista por id pessoa
    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.findAll().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }
   */



    //------------------------------------------------------------------------------------------------------------------
    //UPDATE
    public EnderecoDTO update(Integer id,
                           EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {

    //todo verificar como pegar a pessoa pelo relacionamento get


        PessoaEntity pessoaEntity = pessoaService.findPessoaById(id);


        PessoaDTO pessoaValidaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        EnderecoEntity enderecoEntityRecuperado = findEnderecoById(id);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoAtualizar, EnderecoEntity.class);

        enderecoEntity.setPessoa(Set.of(pessoaEntity));

        log.info("Atualizando endereço...");

        // Chamando o update (update passando objeto convertido na linha anterior)
        enderecoEntityRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEntityRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoEntityRecuperado.setPais(enderecoAtualizar.getPais());

        return retornarDTO(enderecoRepository.save(enderecoEntityRecuperado));


        //EnderecoEntity enderecoEntityRecuperado = findEnderecoById(id);

        //pessoaEntity.setPet(null);

        /*
        //checando se o endereço existe e alterando uma linha da lista de endereços pelo id do parâmetro
        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(enderecoEntityRecuperado.getIdPessoa());
        */


    }

    //------------------------------------------------------------------------------------------------------------------
    //DELETE
    public void delete(Integer id) throws RegraDeNegocioException {

        EnderecoEntity enderecoEntityRecuperado = findEnderecoById(id);

        log.info("Excluindo endereço...");

        enderecoRepository.delete(enderecoEntityRecuperado);
    }

    //------------------------------------------------------------------------------------------------------------------
    //MÉTODOS AUXILIARES:

    //ENCONTRA ENDEREÇO PELO ID - ver usage
    public EnderecoEntity findEnderecoById(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }

    //MÉTODO DTO PARA ENTITY
    public EnderecoEntity converterDTO(EnderecoCreateDTO dto) {
        return objectMapper.convertValue(dto, EnderecoEntity.class);
    }

    //MÉTODO ENTITY PARA DTO
    public EnderecoDTO retornarDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

}

/*
    @Autowired
    private EmailService emailService;

*/
