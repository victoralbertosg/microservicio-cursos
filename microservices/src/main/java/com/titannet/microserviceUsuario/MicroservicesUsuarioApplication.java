package com.titannet.microserviceUsuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.titannet.microservivios.commons.alumnos.entity"})
public class MicroservicesUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesUsuarioApplication.class, args);
	}

}
