package com.laboratorio.demo.services;

import java.util.List;

public interface IservicioGenerico<E> {
	public List<E> findAll() throws Exception;

	public E findById(int id) throws Exception;

	public E save(E entityForm) throws Exception;

	public E update(int id, E entityForm) throws Exception;

	public int countPages(int page, int size) throws Exception;

	public List<E> findAll(int page, int size) throws Exception;
}
