package service.impl;

import java.util.List;
import java.util.UUID;

import domain.Promotion_Product;
import repository.Promotion_ProductRepository;
import service.Promotion_ProductService;

public class Promotion_ProductServiceImpl implements Promotion_ProductService{
	private Promotion_ProductRepository promotion_ProductRepository;
	public Promotion_ProductServiceImpl() {
		promotion_ProductRepository=new Promotion_ProductRepository();
	}
	@Override
	public List<Promotion_Product> findAll() {
		return promotion_ProductRepository.findAll();
	}
	@Override
	public List<Promotion_Product> findAll(int first, int size) {
		return promotion_ProductRepository.findAll(first, size);
	}
	@Override
	public Promotion_Product findByID(UUID key) {
		return promotion_ProductRepository.findByID(key);
	}
	@Override
	public void insert(Promotion_Product entity) throws Exception {
		promotion_ProductRepository.insert(entity);
	}
	@Override
	public void update(Promotion_Product entity) throws Exception {
		promotion_ProductRepository.update(entity);
	}
	@Override
	public void remove(UUID key) throws Exception {
		promotion_ProductRepository.remove(key);
	}
	@Override
	public Long count() {
		return promotion_ProductRepository.count();
	}
	
}