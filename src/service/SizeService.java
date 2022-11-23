package service;

import java.util.List;
import java.util.UUID;

import domain.Size;

public interface SizeService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Size entity) throws Exception;

	void insert(Size entity) throws Exception;

	Size findByID(UUID key);

	List<Size> findAll(int first, int size);

	List<Size> findAll();

    List<Size> findByTypeEqual(int i);

    List<Size> findByTypeNotEqual(int i);

    void setType(UUID id, int type) throws Exception;
	
}