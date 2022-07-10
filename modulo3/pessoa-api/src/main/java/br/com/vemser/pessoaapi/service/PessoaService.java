package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j //PARA USAR O LOG
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    //----CREATE
    public Pessoa create(Pessoa pessoa) {

        log.info("Criando a pessoa...");
        Pessoa p = pessoaRepository.create(pessoa);

        log.warn("Pessoa " + p.getNome() + " criada!");
        return pessoaRepository.create(p);
    }


    //----READ
    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }


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

    /*
    //TODO DÚVIDA: Precisa de Response Entity no delete? Pois com ResponseEntity ele exige um retorno.
    //----DELETE
    public Pessoa delete(Integer id) throws Exception {

        Pessoa pessoaRecuperada = findPessoaById(id);

        log.info("Excluindo pessoa " + pessoaRecuperada.getNome());
        pessoaRepository.list().remove(pessoaRecuperada);

        log.warn("Pessoa excluída!");
        return pessoaRecuperada;
    }
    */

