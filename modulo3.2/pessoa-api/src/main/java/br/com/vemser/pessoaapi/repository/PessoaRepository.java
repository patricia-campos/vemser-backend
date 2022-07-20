package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    //------------------------------------------------------------------------------------------------------------------
    public List<PessoaEntity> findByCpf(String cpf);

    public List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);

    public List<PessoaEntity> findByidPet(Integer idPessoa);

}