package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ReturnDTO {

    private String code;
    private String type;
    private String message;

}


//Vai buscar o retorno do endpoint das api's.
//É o ResponseBody que retorna na execução do endpoint