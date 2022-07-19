package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j //PARA USAR O LOG
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;


    //------------------------------------------------------------------------------------------------------------------
    //CREATE
    public PessoaDTO create(PessoaCreateDTO pessoaDTO) throws RegraDeNegocioException {

        log.info("Criando a pessoa...");
        PessoaEntity pessoaEntity = converterDTO(pessoaDTO);

        //Salvando no BD
        return retornarDTO(pessoaRepository.save(pessoaEntity));
    }

    //------------------------------------------------------------------------------------------------------------------
    //READ
    //lista todos
    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //lista por nome
    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //lista por id pessoa
    public List<PessoaDTO> listByIdPessoa(Integer idPessoa) {

        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //------------------------------------------------------------------------------------------------------------------
    //UPDATE
    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaDTO) throws RegraDeNegocioException {

        PessoaEntity pessoaRecuperada = findPessoaById(id);

        log.info("Atualizando pessoa...");

        pessoaRecuperada.setCpf(pessoaDTO.getCpf());
        pessoaRecuperada.setEmail(pessoaDTO.getEmail());
        pessoaRecuperada.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoaRecuperada.setNome(pessoaDTO.getNome());

        return retornarDTO(pessoaRepository.save(pessoaRecuperada));
    }

    //------------------------------------------------------------------------------------------------------------------
    //DELETE
    public void delete(Integer id) throws RegraDeNegocioException {

        PessoaEntity pessoaRecuperada = findPessoaById(id);

        log.info("Excluindo pessoa...");
        pessoaRepository.delete(pessoaRecuperada);

    }

    //------------------------------------------------------------------------------------------------------------------
    //MÉTODOS AUXILIARES:

    //ENCONTRA PESSOA PELO ID - ver usage
    public PessoaEntity findPessoaById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    //MÉTODO DTO PARA ENTITY
    public PessoaEntity converterDTO(PessoaCreateDTO dto) {
        return objectMapper.convertValue(dto, PessoaEntity.class);
    }

    //MÉTODO ENTITY PARA DTO
    public PessoaDTO retornarDTO(PessoaEntity pessoaEntity) {
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }
}





        /*
        ANOTAÇÕES:

        @Autowired
        private EmailService emailService;


        //Chama método de envio de e-mail

        emailService.sendEmailPessoaCriada(pessoaDTO, pessoaEntity);
        log.warn("Enviando E-mail.. " + pessoaDTO.getEmail()+ "!");


         //Chama método de envio de e-mail
        emailService.sendEmailPessoaAlterada(pessoaDTO);
        log.warn("Enviando E-mail.. " + pessoaDTO.getEmail()+ "!");


        //Chama método de envio de e-mail
        emailService.sendEmailPessoaDeletada(pessoaRecuperada);
        log.warn("Enviando E-mail.. " + pessoaRecuperada.getEmail()+ "!");
        */


