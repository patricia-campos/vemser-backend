package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public EnderecoService(){

        enderecoRepository = new EnderecoRepository();
    }

    //checando se a pessoa existe e criando um novo endereço na lista
    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception{
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new Exception("Pessoa não cadastrada"));

        endereco.setIdPessoa(pessoa.getIdPessoa());

        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list(){
        return enderecoRepository.list();
    }


    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws Exception {

        //checando se o endereço existe e alterando uma linha da lista de endereços pelo id do parâmetro
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não localizado"));

        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoRecuperado.getCep());
        enderecoRecuperado.setCidade(enderecoRecuperado.getCidade());
        enderecoRecuperado.setEstado(enderecoRecuperado.getEstado());
        enderecoRecuperado.setPais(enderecoRecuperado.getPais());

        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {

        enderecoRepository.delete(id);
    }

    //Lista pelo id pessoa
    public List<Endereco> listByIdPessoa(Integer idPessoa) {

        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    //lista pelo id endereço
    public List<Endereco> listByIdEndereco(Integer idEndereco) {

        return enderecoRepository.listByIdEndereco(idEndereco);
    }

}
