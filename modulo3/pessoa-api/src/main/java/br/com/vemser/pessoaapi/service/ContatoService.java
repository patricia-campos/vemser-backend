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


    public Contato create(Integer idPessoa, Contato contato) throws Exception{

        //Puxei o método de encontrar pessoa by Id do PessoaService
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(idPessoa);

        contato.setIdPessoa(pessoaRecuperada.getIdPessoa());

        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }
    
    public Contato update(Integer id,Contato contato) throws Exception {

        Contato contatoRecuperado = findContatoById(id);

        contatoRecuperado.setTipo(contato.getTipo());
        contatoRecuperado.setNumero(contato.getNumero());
        contatoRecuperado.setDescricao(contato.getDescricao());

        return contatoRecuperado;
    }



    public void delete(Integer id) throws Exception {

        Contato contatoRecuperado = findContatoById(id);
        contatoRepository.list().remove(contatoRecuperado);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        
        return contatoRepository.listByIdPessoa(idPessoa);
    }


    private Contato findContatoById(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(x -> x.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoRecuperado;
    }



}
