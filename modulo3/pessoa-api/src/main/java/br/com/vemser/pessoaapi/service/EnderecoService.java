package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;

import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;


    //checando se a pessoa existe e criando um novo endereço na lista - REGRA DE NEGÓCIO
    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception{

        //Puxei o método de encontrar pessoa by Id do PessoaService
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(idPessoa);

        endereco.setIdPessoa(pessoaRecuperada.getIdPessoa());


        return enderecoRepository.create(endereco);
    }


    //chama impressão da lista s/ filtro
    public List<Endereco> list(){
        return enderecoRepository.list();
    }


    //checando se endereço existe alterando endereço na lista - REGRA DE NEGÓCIO
    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws Exception {

        //checando se o endereço existe e alterando uma linha da lista de endereços pelo id do parâmetro
        Endereco enderecoRecuperado = findEnderecoById(id);

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


    //Deletando da lista através do id passado pelo parâmetro
    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = findEnderecoById(id);

        enderecoRepository.list().remove(enderecoRecuperado);
    }

    //Lista pelo id pessoa
    public List<Endereco> listByIdPessoa(Integer idPessoa) {

        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    //lista pelo id endereço
    public List<Endereco> listByIdEndereco(Integer idEndereco) {

        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    //ENCONTRA ENDEREÇO PELO ID - ver usage
    public Endereco findEnderecoById(Integer id) throws Exception {

        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));

        return enderecoRecuperado;
    }


}