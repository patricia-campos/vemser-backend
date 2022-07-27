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


    //==================================================================================================================
    //READ / GET

    //lista todos
    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //------------------------------------------------------------------------------------------------------------------

    /* //TODO IMPLEMENTAR NOVAMENTE
    //lista por pai/ mãe do pet
    public List<PetDTO> listByIdPessoa(Integer idPessoa) {

        return petRepository.findAll().stream()
                .filter(pet -> pet.getIdPessoa().equals(idPessoa))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }
    */

    //==================================================================================================================
    //CREATE / POST

    public PetDTO create(Integer idPessoa, PetCreateDTO petDTO) throws RegraDeNegocioException {

        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(idPessoa); //recuperando pai/mãe do pet

        PetEntity petEntity = objectMapper.convertValue(petDTO, PetEntity.class); //set agora é pelo relacionamento
        petEntity.setPessoa(pessoaRecuperada);

        PetEntity petCriado = petRepository.save(petEntity);
        log.info("Adicionando pet...");

        PetDTO petRetDto = objectMapper.convertValue(petCriado, PetDTO.class); //retorno pro controller após operação
        return petRetDto;

    }

    //==================================================================================================================
    //UPDATE / PUT

    public PetDTO update(Integer id,
                         PetCreateDTO pet) throws RegraDeNegocioException {

        PetEntity petEntityResgatado = findBichinhoById(id); //Busca dados do pet a ser alterado
        PessoaEntity pessoaEntity = petEntityResgatado.getPessoa();
        pessoaEntity.setPet(null);


        //checando se o bichinho existe e alterando seus dados na lista, pelo id da pessoa
        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(pet.getIdPessoa());

        log.info("Atualizando pet...");

        // Chamando o update (passando objeto convertido na linha anterior)
        petEntityResgatado.setTipo(pet.getTipo());
        petEntityResgatado.setNome(pet.getNome());
        petEntityResgatado.setPessoa(pessoaRecuperada);
        pessoaRecuperada.setPet(petEntityResgatado);
        pessoaService.salvar(pessoaRecuperada);

        if (! pessoaRecuperada.getIdPessoa() .equals(pessoaEntity.getIdPessoa())) {
            pessoaService.salvar(pessoaEntity);
        }

        return retornarDTO(petRepository.save(petEntityResgatado));
    }

    //==================================================================================================================
    //DELETE

    public void delete(Integer id) throws RegraDeNegocioException {

        PetEntity petEntityResgatado = findBichinhoById(id);
        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(petEntityResgatado.getIdPessoa());//Checa se existe

        log.info("Excluindo pet");

        petRepository.delete(petEntityResgatado);

    }

    //==================================================================================================================
    //MÉTODOS AUXILIARES

    //ENCONTRA PET PELO ID - ver usage
    private PetEntity findBichinhoById(Integer id) throws RegraDeNegocioException {
        return petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
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
