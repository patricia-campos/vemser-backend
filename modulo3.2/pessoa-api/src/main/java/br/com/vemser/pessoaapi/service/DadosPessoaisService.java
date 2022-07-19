package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//usando a api dados pessoais hospedada no heroku

@Service
public class DadosPessoaisService {

        @Autowired
        private DadosPessoaisClient dadosPessoaisClient;
        @Autowired
        private ObjectMapper objectMapper;


        //----CREATE
        public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
            return dadosPessoaisClient.post(dadosPessoaisDTO);
        }

        //----READ

        //todos
        public List<DadosPessoaisDTO> listarTodos() {
            return dadosPessoaisClient.getAll();
        }

        //por cpf
        public DadosPessoaisDTO listarPorCpf(String cpf) {
            return dadosPessoaisClient.get(cpf);
        }


        //----UPDATE
        public DadosPessoaisDTO put (String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
            return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
        }


        //----DELETE
        public void delete (String cpf) {
            dadosPessoaisClient.delete(cpf);
        }

}



