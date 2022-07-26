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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    //==================================================================================================================
    //                                                GET / READ
    //==================================================================================================================

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
    public List<PessoaDTO> findByCpf(String cpf) {

        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getCpf().equals(cpf))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }


    //==================================================================================================================
    //                                               POST / CREATE
    //==================================================================================================================

    public PessoaDTO create(PessoaCreateDTO pessoaDTO) throws RegraDeNegocioException {

        log.info("Criando a pessoa...");
        PessoaEntity pessoaEntity = converterDTO(pessoaDTO);

        //Salvando no BD
        return retornarDTO(pessoaRepository.save(pessoaEntity));
    }


    //==================================================================================================================
    //                                                PUT / UPDATE
    //==================================================================================================================

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
    //                                                 DELETE
    //==================================================================================================================

    public void delete(Integer id) throws RegraDeNegocioException {

        PessoaEntity pessoaRecuperada = findPessoaById(id);

        log.info("Excluindo pessoa...");
        pessoaRepository.delete(pessoaRecuperada);
    }


    //==================================================================================================================
    //                                                CONSULTAS
    //==================================================================================================================

    //Juntando Relação por relação
    // Lista Pessoa & Contato
    public List<PessoaDTO> listarPessoaEContato() {
        return pessoaRepository.findAll().stream().map(pessoaEntity -> {
            PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
            pessoaDTO.setContatosDTO(pessoaEntity.getContatos().stream()
                    .map(this::contatoretornarDTO).collect(Collectors.toList()));
            return pessoaDTO;
        }).toList();
    }

    //------------------------------------------------------------------------------------------------------------------

    // Juntando Relação por relação
    // Lista Pessoa & Endereço
    public List<PessoaDTO> listarPessoaEEndereco() {
        return pessoaRepository.findAll().stream().map(pessoaEntity -> {
            PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
            pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecos().stream()
                    .map(this::enderecoretornarDTO).collect(Collectors.toList()));
            return pessoaDTO;
        }).toList();
    }

    //------------------------------------------------------------------------------------------------------------------

    // Juntando Relação por relação
    // Lista Pessoa & Pets
    public List<PessoaDTO> listarPessoaEPets() {
        return pessoaRepository.findAll().stream().map(pessoaEntity -> {
            PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
            pessoaDTO.setPetDTO(this.petretornarDTO(pessoaEntity.getPet()));
            return pessoaDTO;
        }).toList();
    }

    //------------------------------------------------------------------------------------------------------------------

    // LISTA PESSOA COMPLETO - HOMEWORK
    public List<PessoaDTO> listPessoaCompleto(Integer idPessoa) {

        if (idPessoa == null) {

            return pessoaRepository.findAll().stream()
                    .map(this::mapperPessoaCompleto)
                    .toList();

        } else {

            return pessoaRepository.findById(idPessoa)
                    .map(this::mapperPessoaCompleto)
                    .stream().toList();
        }
    }


    public PessoaDTO mapperPessoaCompleto(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);

        pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecos().stream()
                .map(this::enderecoretornarDTO).toList());

        pessoaDTO.setContatosDTO(pessoaEntity.getContatos().stream()
                .map(this::contatoretornarDTO).toList());

        pessoaDTO.setPetDTO(petretornarDTO(pessoaEntity.getPet()));
        return pessoaDTO;
    }
        /*
     */

        public PageDTO<RelatorioPersonalizadoDTO> relatorioPersonalizadoDTO(Integer idPessoa, Integer pagina, Integer quantidadeRegistros) {
            Pageable pageable = PageRequest.of(pagina, quantidadeRegistros);
            Page<RelatorioPersonalizadoDTO> page = pessoaRepository.relatorioPersonalizadoDTO(idPessoa, pageable);
            List<RelatorioPersonalizadoDTO> pessoaDTOS = page.getContent().stream()
                    .toList();
            return new PageDTO<>(page.getTotalElements(), page.getTotalPages(), pagina, quantidadeRegistros, pessoaDTOS);

        }

    //==================================================================================================================
    //                                            MÉTODOS AUXILIARES
    //==================================================================================================================

    //ENCONTRA PESSOA PELO ID - ver usage
    public PessoaEntity findPessoaById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    //MÉTODO PARA SALVAR
    public PessoaEntity salvar(PessoaEntity pessoaEntity) {
        return this.pessoaRepository.save(pessoaEntity);
    }

    //------------------------------------------------------------------------------------------------------------------

    //MÉTODO QUE CONVERTE DE DTO PARA ENTITY
    public PessoaEntity converterDTO(PessoaCreateDTO dto) {
        return objectMapper.convertValue(dto, PessoaEntity.class);
    }

    //MÉTODO QUE CONVERTE DE ENTITY PARA DTO
    public PessoaDTO retornarDTO(PessoaEntity pessoaEntity) {
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    //------------------------------------------------------------------------------------------------------------------

    //MAPPERS DAS CONSULTAS

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
        //TODO REIMPLEMENTAR O E-MAIL

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
