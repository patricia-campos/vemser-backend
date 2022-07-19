package br.com.vemser.pessoaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //HABILITA O USO DA FEIGN CLIENT
public class PessoaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApiApplication.class, args);
	}

}

//Service da nossa aplicação -- chamamos a interface nesse caso, e não o service
// TODO REFORÇAR ESSE CONCEITO
