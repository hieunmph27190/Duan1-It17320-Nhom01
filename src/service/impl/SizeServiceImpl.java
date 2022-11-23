package service.impl;

import java.util.List;
import java.util.UUID;

import domain.Size;
import repository.SizeRepository;
import service.SizeService;

public class SizeServiceImpl implements SizeService {
	private SizeRepository sizeRepository;

	public SizeServiceImpl() {
		sizeRepository = new SizeRepository();
	}

	@Override
	public List<Size> findAll() {
		return sizeRepository.findAll();
	}

	@Override
	public List<Size> findAll(int first, int size) {
		return sizeRepository.findAll(first, size);
	}

	@Override
	public Size findByID(UUID key) {
		return sizeRepository.findByID(key);
	}

	@Override
	public void insert(Size entity) throws Exception {
		sizeRepository.insert(entity);
	}

	@Override
	public void update(Size entity) throws Exception {
		sizeRepository.update(entity);
	}

	@Override
	public void remove(UUID key) throws Exception {
		sizeRepository.remove(key);
	}

	@Override
	public Long count() {
		return sizeRepository.count();
	}

    public List<Size> findByTypeEqual(int i) {
        return sizeRepository.findByTypeEqual(i);
    }

    public List<Size> findByTypeNotEqual(int i) {
        return sizeRepository.findByTypeNotEqual(i);
    }

    public void setType(UUID id, int type) throws Exception {
        sizeRepository.setType(id, type);
    }

}