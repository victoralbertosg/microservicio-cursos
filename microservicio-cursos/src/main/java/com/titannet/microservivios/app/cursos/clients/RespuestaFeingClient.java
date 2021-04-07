package com.titannet.microservivios.app.cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="microservicio-respuestas")
public interface RespuestaFeingClient {
	@GetMapping("/alumno/{alumnoId}/examenes-respondidos")
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(@PathVariable Long alumnoId );
}
