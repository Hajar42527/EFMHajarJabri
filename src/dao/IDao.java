package dao;

import java.util.List;

public interface IDao<T,D> {
	
	List<T> getAll();
	
	T getOne(D id);
	
	boolean save(T obj);
	
	boolean update(T obj);
	
	boolean delete(T obj);
}
