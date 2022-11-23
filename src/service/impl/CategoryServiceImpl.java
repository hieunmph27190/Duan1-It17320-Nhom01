package service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Category;
import repository.CategoryRepository;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepository;
	public CategoryServiceImpl() {
		categoryRepository= new CategoryRepository();
	}
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	@Override
	public List<Category> findAll(int first, int size) {
		return categoryRepository.findAll(first, size);
	}
	@Override
	public Category findByID(UUID key) {
		return categoryRepository.findByID(key);
	}
	@Override
	public void insert(Category entity) throws Exception {
		categoryRepository.insert(entity);
	}
	@Override
	public void update(Category entity) throws Exception {
		categoryRepository.update(entity);
	}
	@Override
	public void remove(UUID key) throws Exception {
		categoryRepository.remove(key);
	}
	@Override
	public Long count() {
		return categoryRepository.count();
	}

    public List<Category> findByTypeEqual(int i) {
        return categoryRepository.findByTypeEqual(i);
    }

    public List<Category> findByTypeNotEqual(int i) {
        return categoryRepository.findByTypeNotEqual(i);
    }

    public void setType(UUID id, int type) throws Exception {
        categoryRepository.setType(id, type);
    }
	
}