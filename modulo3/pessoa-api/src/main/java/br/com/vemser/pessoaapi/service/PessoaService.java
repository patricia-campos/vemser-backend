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


    //----READ
    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }


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


