package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    /*

    //ISSO DEVE SER NA SERVICE
    @Query("SELECT e " +
            "FROM ENDERECO e "+
            "WHERE e.pais = :pais"
    )
    List<EnderecoEntity> listEnderecoPorPais(String pais);

    */

}