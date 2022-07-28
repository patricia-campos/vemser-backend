package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UsuarioDTO {
    @Schema(description = "id do usuário", example = "1")
    private Integer idUsuario;
}
