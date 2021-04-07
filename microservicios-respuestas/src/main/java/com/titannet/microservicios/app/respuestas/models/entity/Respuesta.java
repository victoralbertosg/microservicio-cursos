package com.titannet.microservicios.app.respuestas.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.titannet.microservivios.commons.alumnos.entity.Alumno;
import com.titannet.microservivios.commons.examenes.entity.Pregunta;

@Entity
@Table(name="respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String texto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Alumno alumno;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Pregunta pregunta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	
	
}
