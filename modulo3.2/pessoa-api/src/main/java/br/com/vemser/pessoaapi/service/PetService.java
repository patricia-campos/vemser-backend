package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j //PARA USAR O LOG
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;


    //------------------------------------------------------------------------------------------------------------------
    //CREATE
    public PetDTO create(Integer idPessoa, PetCreateDTO petDTO) throws RegraDeNegocioException {

        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(idPessoa); //recuperando pai/mãe do pet
        petDTO.setIdPessoa(pessoaRecuperada.getIdPessoa());                     //add o pet

        log.info("Adicionando pet...");

        PetEntity petEntity = converterDTO(petDTO); //abrindo o dto para poder manipular o create

        //Salvando no BD
        return retornarDTO(petRepository.save(petEntity));

    }

    //------------------------------------------------------------------------------------------------------------------
    //READ
    //lista todos
    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //lista por pai/ mãe do pet
    public List<PetDTO> listByIdPessoa(Integer idPessoa) {

        return petRepository.findAll().stream()
                .filter(pet -> pet.getIdPessoa().equals(idPessoa))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //------------------------------------------------------------------------------------------------------------------
    //UPDATE
    public PetDTO update(Integer id,
                         PetCreateDTO pet) throws RegraDeNegocioException {

        PetEntity petEntityResgatado = findBichinhoById(id);

        //checando se o bichinho existe e alterando seus dados na lista de bichinhos, pelo id do parâmetro
        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(petEntityResgatado.getIdPessoa());

        log.info("Atualizando pet...");

        // Chamando o update (update passando objeto convertido na linha anterior)
        petEntityResgatado.setTipo(pet.getTipo());
        petEntityResgatado.setNome(pet.getNome());

        return retornarDTO(petRepository.save(petEntityResgatado));
    }

    //------------------------------------------------------------------------------------------------------------------
    //DELETE
    public void delete(Integer id) throws RegraDeNegocioException {

        PetEntity petEntityResgatado = findBichinhoById(id);
        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(petEntityResgatado.getIdPessoa());

        log.info("Excluindo pet");

        petRepository.delete(petEntityResgatado);

    }

    //------------------------------------------------------------------------------------------------------------------
    //MÉTODOS AUXILIARES:

    //ENCONTRA CONTATO PELO ID - ver usage
    private PetEntity findBichinhoById(Integer id) throws RegraDeNegocioException {
        return petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Bichinho não encontrado"));
    }

    //MÉTODO DTO PARA ENTITY
    public PetEntity converterDTO(PetCreateDTO dto) {
        return objectMapper.convertValue(dto, PetEntity.class);
    }

    //MÉTODO ENTITY PARA DTO
    public PetDTO retornarDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }
}
