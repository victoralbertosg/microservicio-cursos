package com.titannet.microservivios.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.titannet.microservivios.commons.alumnos.entity",
	"com.titannet.microservivios.app.cursos.models.entity",
	"com.titannet.microservivios.commons.examenes.entity"})
public class MicroservicioCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCursosApplication.class, args);
	}

}
