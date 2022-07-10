package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;

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


    //----CREATE
    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception{

        log.info("Adicionando endereço...");
        //Puxei o método de encontrar pessoa by Id do PessoaService
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(idPessoa);

        endereco.setIdPessoa(pessoaRecuperada.getIdPessoa());
        log.info("Adicionado novo endereço de " + pessoaRecuperada.getNome());
        return enderecoRepository.create(endereco);
    }


    //----READ
    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    //Lista pelo id pessoa
    public List<Endereco> listByIdPessoa(Integer idPessoa) {

        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    //lista pelo id endereço
    public List<Endereco> listByIdEndereco(Integer idEndereco) {

        return enderecoRepository.listByIdEndereco(idEndereco);
    }


    //----UPDATE
    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws Exception {

        Endereco enderecoRecuperado = findEnderecoById(id);

        //TODO ARRUMAR ISSO -checando se o endereço existe e alterando uma linha da lista de endereços pelo id do parâmetro
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(enderecoRecuperado.getIdPessoa());

        log.info("Atualizando ENDERECO  " + enderecoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoRecuperado.getCep());
        enderecoRecuperado.setCidade(enderecoRecuperado.getCidade());
        enderecoRecuperado.setEstado(enderecoRecuperado.getEstado());
        enderecoRecuperado.setPais(enderecoRecuperado.getPais());

        log.warn("Endereço "+ enderecoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + " atualizado!");
        return enderecoRecuperado;
    }


    //----DELETE
    public void delete(Integer id) throws Exception {

        Endereco enderecoRecuperado = findEnderecoById(id);
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(enderecoRecuperado.getIdPessoa());

        log.info("Excluindo endereco  " + enderecoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome());

        enderecoRepository.list().remove(enderecoRecuperado);

        log.warn("Endereco "+ enderecoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + " excluído!");
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