package service;

import java.util.List;
import java.util.UUID;

import domain.Image;

public interface ImageService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Image entity) throws Exception;

	void insert(Image entity) throws Exception;

	Image findByID(UUID key);

	List<Image> findAll(int first, int size);

	List<Image> findAll();
}