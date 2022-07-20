package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetEntity,Integer> {
}
