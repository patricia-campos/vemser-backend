package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j //PARA USAR O LOG
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;


    //------------------------------------------------------------------------------------------------------------------
    //CREATE
    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoDTO) throws RegraDeNegocioException{

        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(idPessoa);
        contatoDTO.setIdPessoa(pessoaRecuperada.getIdPessoa());

        log.info("Adicionando contato...");

        ContatoEntity contatoEntity = converterDTO(contatoDTO);

        //Salvando no BD
        return retornarDTO(contatoRepository.save(contatoEntity));

    }

    //------------------------------------------------------------------------------------------------------------------
    //READ
    //lista todos
    public List<ContatoDTO> list(){
        return contatoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //lista por id pessoa
    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {

        return contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //------------------------------------------------------------------------------------------------------------------
    //UPDATE
    public ContatoDTO update(Integer id,
                          ContatoCreateDTO contato) throws RegraDeNegocioException {

        ContatoEntity contatoEntityRecuperado = findContatoById(id);

        //checando se o endereço existe e alterando uma linha da lista de endereços pelo id do parâmetro
        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(contatoEntityRecuperado.getIdPessoa());

        log.info("Atualizando contato  " );

        // Chamando o update (update passando objeto convertido na linha anterior)
        contatoEntityRecuperado.setTipo(contato.getTipo());
        contatoEntityRecuperado.setNumero(contato.getNumero());
        contatoEntityRecuperado.setDescricao(contato.getDescricao());

        return retornarDTO(contatoRepository.save(contatoEntityRecuperado));
    }

    //------------------------------------------------------------------------------------------------------------------
    //DELETE
    public void delete(Integer id) throws RegraDeNegocioException {

        ContatoEntity contatoEntityRecuperado = findContatoById(id);
        PessoaEntity pessoaRecuperada = pessoaService.findPessoaById(contatoEntityRecuperado.getIdPessoa());

        log.info("Excluindo contato ");

        contatoRepository.delete(contatoEntityRecuperado);

    }

    //------------------------------------------------------------------------------------------------------------------
    //MÉTODOS AUXILIARES:

    //ENCONTRA CONTATO PELO ID - ver usage
    private ContatoEntity findContatoById(Integer id) throws RegraDeNegocioException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }

    //MÉTODO DTO PARA ENTITY
    public ContatoEntity converterDTO(ContatoCreateDTO dto) {
        return objectMapper.convertValue(dto, ContatoEntity.class);
    }

    //MÉTODO ENTITY PARA DTO
    public ContatoDTO retornarDTO(ContatoEntity contatoEntity) {
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }
}
