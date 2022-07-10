package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@Slf4j //PARA USAR O LOG
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;


    //----CREATE
    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception{

        log.info("Adicionando contato...");
        //Puxei o método de encontrar pessoa by Id do PessoaService
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(idPessoa);
        contato.setIdPessoa(pessoaRecuperada.getIdPessoa());

        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        Contato contatoCriado = contatoRepository.create(contatoEntity);

        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);

        log.info("Adicionado novo contato de " + pessoaRecuperada.getNome());
        return contatoDTO;
    }


    //----READ
    public List<Contato> list(){
        return contatoRepository.list();
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {

        return contatoRepository.listByIdPessoa(idPessoa);
    }


    //----UPDATE
    public ContatoDTO update(Integer id,
                          ContatoCreateDTO contato) throws Exception {

        Contato contatoRecuperado = findContatoById(id);

        //checando se o endereço existe e alterando uma linha da lista de endereços pelo id do parâmetro
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(contatoRecuperado.getIdPessoa());

        log.info("Atualizando contato  " + contatoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome());

        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class); //convertendo o contato para objeto chamado contatoEntity
        contatoRecuperado.setTipo(contatoEntity.getTipo());
        contatoRecuperado.setNumero(contatoEntity.getNumero());
        contatoRecuperado.setDescricao(contatoEntity.getDescricao());

        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO = objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);

        log.warn("Contato "+ contatoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + " atualizado!");

        return contatoDTO;
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
