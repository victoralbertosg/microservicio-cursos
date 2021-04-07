package com.titannet.microservivios.app.cursos.services;


import com.titannet.microservivios.app.cursos.models.entity.Curso;

import com.titannet.microservivios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	public Curso findCursoByAlumno(Long id);
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId );
}
