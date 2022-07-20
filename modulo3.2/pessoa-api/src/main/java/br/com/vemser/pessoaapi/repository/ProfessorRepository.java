package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.vemser.pessoaapi.entity.pk.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK > {

        //ProfessorEntity findAllByNome(String nome);

       // ProfessorEntity findByCpf(String cpf);

        //n estou certa disso
    }

    //TODO VER ISSO AQUI
