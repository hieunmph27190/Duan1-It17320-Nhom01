package service;

import java.util.List;
import java.util.UUID;

import domain.Promotion;

public interface PromotionService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Promotion entity) throws Exception;

	void insert(Promotion entity) throws Exception;

	Promotion findByID(UUID key);

	List<Promotion> findAll(int first, int size);

	List<Promotion> findAll();
	
}