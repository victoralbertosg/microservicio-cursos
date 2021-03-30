package com.titannet.microservivios.commons.examenes.services;

import java.util.List;

import com.titannet.microservivios.commons.examenes.entity.Asignatura;
import com.titannet.microservivios.commons.examenes.entity.Examen;
import com.titannet.microservivios.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen> {
	public List<Examen> findByNombre (String term);
	public Iterable<Asignatura> findAllAsignaturas();
}
