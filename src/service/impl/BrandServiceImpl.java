package service.impl;

import java.util.List;
import java.util.UUID;

import domain.Brand;
import repository.BrandRepository;
import service.BrandService;

public class BrandServiceImpl implements BrandService {
	private BrandRepository BrandRepository;
	public BrandServiceImpl() {
		BrandRepository=new BrandRepository();
	}
	@Override
	public List<Brand> findAll() {
		return BrandRepository.findAll();
	}
	@Override
	public List<Brand> findAll(int first, int size) {
		return BrandRepository.findAll(first, size);
	}
	@Override
	public Brand findByID(UUID key) {
		return BrandRepository.findByID(key);
	}
	@Override
	public void insert(Brand entity) throws Exception {
		BrandRepository.insert(entity);
	}
	@Override
	public void update(Brand entity) throws Exception {
		BrandRepository.update(entity);
	}
	@Override
	public void remove(UUID key) throws Exception {
		BrandRepository.remove(key);
	}
	@Override
	public Long count() {
		return BrandRepository.count();
	}

    public List<Brand> findByTypeEqual(int i) {
        return BrandRepository.findByTypeEqual(i);
    }

    public List<Brand> findByTypeNotEqual(int i) {
        return BrandRepository.findByTypeNotEqual(i);
    }

    public void setType(UUID id, int type) throws Exception {
        BrandRepository.setType(id, type);
    }
	
}