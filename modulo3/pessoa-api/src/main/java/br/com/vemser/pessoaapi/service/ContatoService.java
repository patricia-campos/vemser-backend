package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Slf4j
@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService pessoaService;

    //----CREATE
    public Contato create(Integer idPessoa, Contato contato) throws Exception{

        log.info("Adicionando contato...");
        //Puxei o método de encontrar pessoa by Id do PessoaService
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(idPessoa);

        contato.setIdPessoa(pessoaRecuperada.getIdPessoa());
        log.info("Adicionado novo contato de " + pessoaRecuperada.getNome());
        return contatoRepository.create(contato);
    }

    //----READ
    public List<Contato> list(){
        return contatoRepository.list();
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {

        return contatoRepository.listByIdPessoa(idPessoa);
    }

    //----UPDATE
    public Contato update(Integer id,
                          Contato contato) throws Exception {

        Contato contatoRecuperado = findContatoById(id);

        //TODO ARRUMAR ISSO -checando se o endereço existe e alterando uma linha da lista de endereços pelo id do parâmetro
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(contatoRecuperado.getIdPessoa());

        log.info("Atualizando contato  " + contatoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome());
        contatoRecuperado.setTipo(contato.getTipo());
        contatoRecuperado.setNumero(contato.getNumero());
        contatoRecuperado.setDescricao(contato.getDescricao());

        log.warn("Contato "+ contatoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + " atualizado!");
        return contatoRecuperado;
    }

    //----DELETE
    public void delete(Integer id) throws Exception {

        Contato contatoRecuperado = findContatoById(id);
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(contatoRecuperado.getIdPessoa());

        log.info("Excluindo contato  " + contatoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome());

        contatoRepository.list().remove(contatoRecuperado);

        log.warn("Contato "+ contatoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + " excluído!");
    }


    //ENCONTRA CONTATO PELO ID - ver usage
    private Contato findContatoById(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(x -> x.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoRecuperado;
    }

}
