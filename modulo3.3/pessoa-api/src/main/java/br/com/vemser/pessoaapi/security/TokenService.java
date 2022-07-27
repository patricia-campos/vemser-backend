package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UsuarioService usuarioService;


    public String getToken(UsuarioEntity usuarioEntity) {

        //por meio do usuário, gerar um token
        String tokenText = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
        String token = Base64.getEncoder().encodeToString(tokenText.getBytes());

        return token;
    }

    //validar se o token é válido e retornar o usuário se for válido
    public Optional<UsuarioEntity> isValid(String token) {

        if (token == null) {
            return Optional.empty();
        }
        //byte[] decodeBytes = Base64.getUrlDecoder().decode(token);
        byte[] decodeBytes = Base64.getMimeDecoder().decode(token);
        String decoded = new String(decodeBytes);
        String[] split = decoded.split(";");
        Optional<UsuarioEntity> optionalUsuario = usuarioService.findByLoginAndSenha(split[0], split[1]);

        return optionalUsuario;
    }
}