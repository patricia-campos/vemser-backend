package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@Slf4j //PARA USAR O LOG
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;


    //----CREATE
    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException{

        //Puxei o método de encontrar pessoa by Id do PessoaService
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(idPessoa);
        endereco.setIdPessoa(pessoaRecuperada.getIdPessoa());

        log.info("Adicionando endereço de " + pessoaRecuperada.getNome());

        // Aqui acontece a conversão do conteúdo do Json através do ObjectMapper - deixa de ser DTO
        Endereco enderecoEntity = objectMapper.convertValue(endereco,Endereco.class);

        // Chamando o create (insert passando objeto convertido na linha anterior)
        Endereco enderecoCriado = enderecoRepository.create(enderecoEntity);

        // Criando o objeto e convertendo para o DTO (que só tem o id) para retornar para o controller
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);

        log.info("Novo endereço de " + pessoaRecuperada.getNome() + " adicionado!");

        //Chama método de envio de e-mail
        emailService.sendEmailEnderecoCriado(enderecoDTO, pessoaRecuperada);
        log.warn("Enviando E-mail.. " + pessoaRecuperada.getEmail()+ "!");

        return enderecoDTO;
    }


    //----READ  //todo dto aqui também?????
    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }


    //----UPDATE
    public EnderecoDTO update(Integer id,
                           EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {

        Endereco enderecoRecuperado = findEnderecoById(id);

        //checando se o endereço existe e alterando uma linha da lista de endereços pelo id do parâmetro
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(enderecoRecuperado.getIdPessoa());

        log.info("Atualizando endereço " + enderecoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + "...");

        // Aqui acontece a conversão do conteúdo do Json através do ObjectMapper - deixa de ser DTO
        Endereco enderecoEntity = objectMapper.convertValue(enderecoAtualizar, Endereco.class);

        // Chamando o update (update passando objeto convertido na linha anterior)
        enderecoRecuperado.setTipo(enderecoEntity.getTipo());
        enderecoRecuperado.setLogradouro(enderecoEntity.getLogradouro());
        enderecoRecuperado.setNumero(enderecoEntity.getNumero());
        enderecoRecuperado.setComplemento(enderecoEntity.getComplemento());
        enderecoRecuperado.setCep(enderecoEntity.getCep());
        enderecoRecuperado.setCidade(enderecoEntity.getCidade());
        enderecoRecuperado.setEstado(enderecoEntity.getEstado());
        enderecoRecuperado.setPais(enderecoEntity.getPais());

        // Criando o objeto e convertendo para o DTO (que só tem o id) para retornar para o controller
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);

        log.warn("Endereço "+ enderecoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + " atualizado!");

        //Chama método de envio de e-mail
        emailService.sendEmailEnderecoAlterado(enderecoDTO, pessoaRecuperada);
        log.warn("Enviando E-mail.. " + pessoaRecuperada.getEmail()+ "!");

        return enderecoDTO;
    }


    //----DELETE
    public void delete(Integer id) throws RegraDeNegocioException {

        Endereco enderecoRecuperado = findEnderecoById(id);
        Pessoa pessoaRecuperada = pessoaService.findPessoaById(enderecoRecuperado.getIdPessoa());

        log.info("Excluindo endereço  " + enderecoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + "...");

        enderecoRepository.list().remove(enderecoRecuperado);

        log.warn("Endereço "+ enderecoRecuperado.getTipo() + " de " + pessoaRecuperada.getNome() + " excluído!");

        //Chama método de envio de e-mail
        emailService.sendEmailEnderecoDeletado(enderecoRecuperado, pessoaRecuperada);
        log.warn("Enviando E-mail.. " + pessoaRecuperada.getEmail()+ "!");
    }



    //ENCONTRA ENDEREÇO PELO ID - ver usage
    public Endereco findEnderecoById(Integer id) throws RegraDeNegocioException {

        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));

        return enderecoRecuperado;
    }

}

//TODO REGRAS DE NEGÓCIO EXCEPTION