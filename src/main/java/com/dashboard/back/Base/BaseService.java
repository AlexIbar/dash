package com.dashboard.back.Base;

import java.util.List;

public interface BaseService<E> {
	public List<E> findAll();
	public E findId(Integer id);
	public E save(E nameClass);
	public E update(E nameClass, Integer id);
	public void delete(Integer id);
}
