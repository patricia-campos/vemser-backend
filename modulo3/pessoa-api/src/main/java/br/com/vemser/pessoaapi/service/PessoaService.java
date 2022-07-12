package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j //PARA USAR O LOG
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;


    //----CREATE
    public PessoaDTO create(PessoaCreateDTO pessoa) {

        log.info("Criando a pessoa...");

        // Aqui acontece a conversão do conteúdo do Json através do ObjectMapper
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);

        // Chamando o create (insert passando objeto convertido na linha anterior)
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);

        // Criando o objeto e convertendo para o DTO (que só tem o id) para retornar para o controller
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        log.warn("Pessoa " + pessoaDTO.getNome() + " criada!");

        emailService.sendEmailPessoaCriada(pessoaDTO, pessoaCriada);
        log.warn("Enviando E-mail.. " + pessoaDTO.getEmail()+ "!");


        return pessoaDTO;
    }


    //----READ
    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

    public List<Pessoa> listByIdPessoa(Integer id) {
        return pessoaRepository.listByIdPessoa(id);
    }


    //----UPDATE
    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {

        Pessoa pessoaRecuperada = findPessoaById(id);

        log.info("Atualizando pessoa " + pessoaRecuperada.getNome() + "...");

        // Aqui acontece a conversão do conteúdo do Json através do ObjectMapper
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);

        // Chamando o update (update passando objeto convertido na linha anterior)
        pessoaRecuperada.setCpf(pessoaEntity.getCpf());
        pessoaRecuperada.setNome(pessoaEntity.getNome());
        pessoaRecuperada.setDataNascimento(pessoaEntity.getDataNascimento());

        // Criando o objeto e convertendo para o DTO (que só tem o id) para retornar para o controller
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);

        log.warn("Pessoa " + pessoaRecuperada.getNome() + " atualizada!");

        emailService.sendEmailPessoaAlterada(pessoaDTO);
        log.warn("Enviando E-mail.. " + pessoaDTO.getEmail()+ "!");

        return pessoaDTO;
    }


    //----DELETE
    public void delete(Integer id) throws Exception {

        Pessoa pessoaRecuperada = findPessoaById(id);

        log.info("Excluindo pessoa " + pessoaRecuperada.getNome() + "...");
        pessoaRepository.list().remove(pessoaRecuperada);

        log.warn("Pessoa" + pessoaRecuperada.getNome() + " excluída!");

        emailService.sendEmailPessoaDeletada(pessoaRecuperada);
        log.warn("Enviando E-mail.. " + pessoaRecuperada.getEmail()+ "!");
    }


    //ENCONTRA PESSOA PELO ID - ver usage
    public Pessoa findPessoaById(Integer id) throws RegraDeNegocioException {

        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return pessoaRecuperada;
    }
}


