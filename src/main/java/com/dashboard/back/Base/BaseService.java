package com.dashboard.back.Base;

import java.util.List;

public interface BaseService<E> {
	public List<E> findAll();
	public E save(E nameClass);
	public E findId(Integer id);
	public void delete(Integer id);
}
