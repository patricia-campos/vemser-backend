package br.com.vemser.pessoaapi.controller;


import br.com.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.security.TokenService;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UsuarioService usuarioService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager; //chama a autenticacao do spring


    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {

        //Está buscando o token do usuário e senha
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha()
                );

        //Passando a responsabilidade de efetuar a autenticação para o Spring
        Authentication authentication = authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);
        log.info("Usuário Autenticado com Sucesso!");
        Object usuarioLogado = authentication.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioLogado;


        //Pega o token do usuario logado
        String token = tokenService.getToken(usuarioEntity);

        //retorna o token
        return token;
    }


    @PostMapping("/registrar")
    public UsuarioDTO cadastrar (@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return usuarioService.registrar(usuarioCreateDTO);
    }
}

