package com.titannet.microservicios.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.titannet.microservivios.commons.alumnos.entity",
	"com.titannet.microservivios.commons.examenes.entity",
	"com.titannet.microservicios.app.respuestas.models.entity"	
})
public class MicroserviciosRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosRespuestasApplication.class, args);
	}
	

}
