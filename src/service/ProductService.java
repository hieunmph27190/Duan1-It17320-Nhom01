package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Product;

public interface ProductService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Product entity) throws Exception;

	void insert(Product entity) throws Exception;

	Product findByID(UUID key);

	List<Product> findAll(int first, int size);

	List<Product> findAll();

       Product FindByNameEqual(String name);

	
}