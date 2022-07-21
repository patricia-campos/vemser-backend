package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@Slf4j //PARA USAR O LOG
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;


    //==================================================================================================================
    //READ / GET

    //Lista todos
    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //------------------------------------------------------------------------------------------------------------------

    //Lista por nome
    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //------------------------------------------------------------------------------------------------------------------

    //Lista por id pessoa
    public List<PessoaDTO> listByIdPessoa(Integer idPessoa) {

        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //------------------------------------------------------------------------------------------------------------------

    //Lista por cpf

    public List<PessoaEntity> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Juntando Relação por relação
    // Pessoa & Contato
    public List<PessoaDTO> listarPessoaEContato() {
        return pessoaRepository.findAll().stream().map(pessoaEntity -> {
            PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
            pessoaDTO.setContatosDTO(pessoaEntity.getContatos().stream()
                    .map(this::contatoretornarDTO).collect(Collectors.toList()));
            return pessoaDTO;
        }).toList();
    }

    //------------------------------------------------------------------------------------------------------------------

    //Juntando Relação por relação
    // Pessoa & Endereço
    public List<PessoaDTO> listarPessoaEEndereco() {
        return pessoaRepository.findAll().stream().map(pessoaEntity -> {
            PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
            pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecos().stream()
                    .map(this::enderecoretornarDTO).collect(Collectors.toList()));
            return pessoaDTO;
        }).toList();
    }

    //------------------------------------------------------------------------------------------------------------------

    //Juntando Relação por relação
    //Pessoa & Pets
    public List<PessoaDTO> listarPessoaEPets() {
        return pessoaRepository.findAll().stream().map(pessoaEntity -> {
            PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
            pessoaDTO.setPetDTO(this.petretornarDTO(pessoaEntity.getPet()));
            return pessoaDTO;
        }).toList();
    }

    //==================================================================================================================
    //CREATE / POST

    public PessoaDTO create(PessoaCreateDTO pessoaDTO) throws RegraDeNegocioException {

        log.info("Criando a pessoa...");
        PessoaEntity pessoaEntity = converterDTO(pessoaDTO);

        //Salvando no BD
        return retornarDTO(pessoaRepository.save(pessoaEntity));
    }


    //==================================================================================================================
    //UPDATE / PUT

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

    //==================================================================================================================
    //DELETE

    public void delete(Integer id) throws RegraDeNegocioException {

        PessoaEntity pessoaRecuperada = findPessoaById(id);

        log.info("Excluindo pessoa...");
        pessoaRepository.delete(pessoaRecuperada);
    }

    //==================================================================================================================
    // HOMEWORK TODO - EM ANDAMENTO

/*
    public List<PessoaDTO> listPessoaCompleto(Integer idPessoa) {

        if (idPessoa == null) {
            //TODO
        }

*/

    //==================================================================================================================
    //MÉTODOS AUXILIARES

    //ENCONTRA PESSOA PELO ID - ver usage
    public PessoaEntity findPessoaById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    //MÉTODO QUE CONVERTE DE DTO PARA ENTITY
    public PessoaEntity converterDTO(PessoaCreateDTO dto) {
        return objectMapper.convertValue(dto, PessoaEntity.class);
    }

    //MÉTODO QUE CONVERTE DE ENTITY PARA DTO
    public PessoaDTO retornarDTO(PessoaEntity pessoaEntity) {
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    //MÉTODO PARA SALVAR
    public PessoaEntity salvar(PessoaEntity pessoaEntity) {
        return this.pessoaRepository.save(pessoaEntity);
    }

    //------------------------------------------------------------------------------------------------------------------

    //TODO - MELHORAR A ORGANIZAÇÃO DISSO

    public ContatoDTO contatoretornarDTO(ContatoEntity contatoEntity) {
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public EnderecoDTO enderecoretornarDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public PetDTO petretornarDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }


    //==================================================================================================================
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

}
