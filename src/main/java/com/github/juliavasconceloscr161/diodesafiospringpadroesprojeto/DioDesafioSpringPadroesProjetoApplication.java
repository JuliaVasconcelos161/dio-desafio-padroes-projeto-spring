package com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioDesafioSpringPadroesProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioDesafioSpringPadroesProjetoApplication.class, args);
	}

}
