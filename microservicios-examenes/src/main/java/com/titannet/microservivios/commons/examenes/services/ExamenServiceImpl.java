package com.titannet.microservivios.commons.examenes.services;



import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.microservivios.commons.examenes.entity.Examen;
import com.titannet.microservivios.commons.examenes.models.repository.ExamenRepository;
import com.titannet.microservivios.commons.services.CommonServiceImp;

@Service
public class ExamenServiceImpl extends CommonServiceImp<Examen,ExamenRepository> implements ExamenService {

	@Override
	@Transactional(readOnly=true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}



}
