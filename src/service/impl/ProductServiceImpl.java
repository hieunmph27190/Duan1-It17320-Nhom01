package service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Product;
import repository.ProductRepository;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;
	public ProductServiceImpl() {
		productRepository = new ProductRepository();
	}
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	@Override
	public List<Product> findAll(int first, int size) {
		return productRepository.findAll(first, size);
	}
	@Override
	public Product findByID(UUID key) {
		return productRepository.findByID(key);
	}
	@Override
	public void insert(Product entity) throws Exception {
		productRepository.insert(entity);
	}
	@Override
	public void update(Product entity) throws Exception {
		productRepository.update(entity);
	}
	@Override
	public void remove(UUID key) throws Exception {
		productRepository.remove(key);
	}
	@Override
	public Long count() {
		return productRepository.count();
	}

    public Product FindByNameEqual(String name) {
        return productRepository.FindByNameEqual(name);
    }
	
}