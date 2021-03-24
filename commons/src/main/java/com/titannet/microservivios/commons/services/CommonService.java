package com.titannet.microservivios.commons.services;

import java.util.Optional;

//E generico de entidad
public interface CommonService<E> {
public Iterable<E> findAll();
public Optional<E>findById(Long id);
public E save(E entity);
public void deleteById(Long id);
}
