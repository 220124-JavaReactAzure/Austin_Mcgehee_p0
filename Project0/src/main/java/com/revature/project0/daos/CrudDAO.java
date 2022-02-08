package com.revature.project0.daos;

import com.revature.project0.utils.collections.List;

public interface CrudDAO<T> {
	
	T create(T newObj);
	
	List<T> findAll();
	T findById(String id);
	
	boolean update(T updatedObj);
	
	boolean delete(String id);

}
