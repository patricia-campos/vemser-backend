package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha);
    // Criando metodo para pegar somente pelo login
    Optional<UsuarioEntity> findByLogin(String login);
}