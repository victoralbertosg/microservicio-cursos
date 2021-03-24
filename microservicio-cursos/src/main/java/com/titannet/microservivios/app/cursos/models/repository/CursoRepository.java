package com.titannet.microservivios.app.cursos.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.titannet.microservivios.app.cursos.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {

	@Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
	public Curso findCursoByAlumno(Long id);
}
