package service.impl;

import java.util.List;
import java.util.UUID;

import domain.Image;
import repository.ImageRepository;
import service.ImageService;

public class ImageServiceImpl implements ImageService{
	 private ImageRepository imageRepository;
	 public ImageServiceImpl() {
		imageRepository = new  ImageRepository();
	}
	@Override
	public List<Image> findAll() {
		return imageRepository.findAll();
	}
	@Override
	public List<Image> findAll(int first, int size) {
		return imageRepository.findAll(first, size);
	}
	@Override
	public Image findByID(UUID key) {
		return imageRepository.findByID(key);
	}
	@Override
	public void insert(Image entity) throws Exception {
		imageRepository.insert(entity);
	}
	@Override
	public void update(Image entity) throws Exception {
		imageRepository.update(entity);
	}
	@Override
	public void remove(UUID key) throws Exception {
		imageRepository.remove(key);
	}
	@Override
	public Long count() {
		return imageRepository.count();
	}
	 
}