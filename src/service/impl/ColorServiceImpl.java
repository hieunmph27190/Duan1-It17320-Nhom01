package service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Color;
import repository.ColorRepository;
import service.ColorService;

public class ColorServiceImpl implements ColorService {
	private ColorRepository colorRepository;
	public ColorServiceImpl() {
		colorRepository =new ColorRepository();
	}
	@Override
	public List<Color> findAll() {
		return colorRepository.findAll();
	}
	@Override
	public List<Color> findAll(int first, int size) {
		return colorRepository.findAll(first, size);
	}
	@Override
	public Color findByID(UUID key) {
		return colorRepository.findByID(key);
	}
	@Override
	public void insert(Color entity) throws Exception {
		colorRepository.insert(entity);
	}
	@Override
	public void update(Color entity) throws Exception {
		colorRepository.update(entity);
	}
	@Override
	public void remove(UUID key) throws Exception {
		colorRepository.remove(key);
	}
	@Override
	public Long count() {
		return colorRepository.count();
	}

    public List<Color> findByTypeEqual(int i) {
        return colorRepository.findByTypeEqual(i);
    }

    public List<Color> findByTypeNotEqual(int i) {
        return colorRepository.findByTypeNotEqual(i);
    }

    public void setType(UUID id, int type) throws Exception {
        colorRepository.setType(id, type);
    }
	
}