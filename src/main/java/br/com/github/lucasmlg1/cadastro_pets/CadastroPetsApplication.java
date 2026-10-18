package br.com.github.lucasmlg1.cadastro_pets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CadastroPetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroPetsApplication.class, args);
	}

}
