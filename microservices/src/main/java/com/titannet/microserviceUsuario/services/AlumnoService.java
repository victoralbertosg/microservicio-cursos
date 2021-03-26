package com.titannet.microserviceUsuario.services;



import java.util.List;

import com.titannet.microservivios.commons.alumnos.entity.Alumno;
import com.titannet.microservivios.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno> {
	public List<Alumno> findByNombreOrApellido (String term);
}
