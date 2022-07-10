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

    //TODO - DTO EM CONSTRUÇÃO ------------------------------------------------------
    @Autowired  //TODO PESQUISAR PARA ENTENDER
    private ObjectMapper objectMapper;
    //TODO - DTO EM CONSTRUÇÃO ------------------------------------------------------


    /*
    //----CREATE
    public Pessoa create(Pessoa pessoa) {

        log.info("Criando a pessoa...");
        Pessoa p = pessoaRepository.create(pessoa);

        log.warn("Pessoa " + p.getNome() + " criada!");
        return pessoaRepository.create(p);
    }
    */


    //TODO - DTO CREATE EM CONSTRUÇÃO - INÍCIO -----------------------------------------------------
    //----CREATE
    public PessoaDTO create(PessoaCreateDTO pessoa) {

        log.info("Criando a pessoa...");

        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        log.warn("Pessoa " + pessoaDTO.getNome() + " criada!");
        return pessoaDTO;
    }
    //TODO - DTO CREATE EM CONSTRUÇÃO - FIM -----------------------------------------------------


    //----READ
    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }


    /*
    //----UPDATE
    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {

        Pessoa pessoaRecuperada = findPessoaById(id);

        log.info("Atualizando pessoa " + pessoaRecuperada.getNome());
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        log.warn("Pessoa atualizada!");
        return pessoaRecuperada;
    }
    */


    //TODO - DTO UPDATE EM CONSTRUÇÃO - INÍCIO -----------------------------------------------------
    //----UPDATE
    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoaRecuperada = findPessoaById(id);

        log.info("Atualizando pessoa " + pessoaRecuperada.getNome());

        Pessoa pessoaEntity = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        pessoaRecuperada.setCpf(pessoaEntity.getCpf());
        pessoaRecuperada.setNome(pessoaEntity.getNome());
        pessoaRecuperada.setDataNascimento(pessoaEntity.getDataNascimento());


        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);

        log.warn("Pessoa atualizada!");


        return pessoaDTO;
    }
    //TODO - DTO UPDATE EM CONSTRUÇÃO - FIM -----------------------------------------------------


    //----DELETE
    public void delete(Integer id) throws Exception {

        Pessoa pessoaRecuperada = findPessoaById(id);

        log.info("Excluindo pessoa " + pessoaRecuperada.getNome());
        pessoaRepository.list().remove(pessoaRecuperada);

        log.warn("Pessoa excluída!");
    }


    //ENCONTRA PESSOA PELO ID - ver usage
    public Pessoa findPessoaById(Integer id) throws Exception {

        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return pessoaRecuperada;
    }
}


