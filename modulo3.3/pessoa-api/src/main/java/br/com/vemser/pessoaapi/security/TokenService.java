package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    private final UsuarioService usuarioService;

    //criando um token JWT
    public String getToken(UsuarioEntity usuarioEntity) {

        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.valueOf(expiration)); //convertendo o value do properts para long

        String token = Jwts.builder()
                .setIssuer("pessoa-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        // retornamos o bearer que puxamos do TokenAuthenticationFilter e adicionamos nosso token,
        // e isso será o retorno do método, que é o token em si no formato jwts

        return TokenAuthenticationFilter.BEARER + token; // retornamos o bearer que puxamos do TokenAuthenticationFilter e adicionamos nosso token, e isso será o retorno do método

    }

    //validar se o token é válido e retornar o usuário se for válido
    public UsernamePasswordAuthenticationToken isValid(String token) {

        if (token == null) {
            return null;
        }

        Claims payload = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)//aqui tb verifica a expiração
                .getBody();

        //busca/ recupera o id que está dentro do body (payload) do JWTS
        Integer idUsuario = payload.get(Claims.ID, Integer.class);

        if(idUsuario != null){

            //como o jws já sinalizou que a chave é válida, estamos buscando do póprio jwt
            // e setando no objeto abaixo
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(idUsuario, null, Collections.emptyList());

            return usernamePasswordAuthenticationToken;
        }
        return null;

    }
}