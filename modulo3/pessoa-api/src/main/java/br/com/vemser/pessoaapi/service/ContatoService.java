package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public ContatoService(){
        
        contatoRepository= new ContatoRepository();
    }

    public Contato create(Integer idPessoa, Contato contato) throws Exception{
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new Exception("Pessoa não localizada"));

        contato.setIdPessoa(pessoa.getIdPessoa());

        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }
    
    public Contato update(Integer id,Contato contato) throws Exception {

        Contato contatoAlterado = contatoRepository.list().stream()
                .filter(x -> x.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));

        contatoAlterado.setTipo(contato.getTipo());
        contatoAlterado.setNumero(contato.getNumero());
        contatoAlterado.setDescricao(contato.getDescricao());

        return contatoAlterado;
    }

    public void delete(Integer id) throws Exception {
        
        contatoRepository.delete(id);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        
        return contatoRepository.listByIdPessoa(idPessoa);
    }
}
