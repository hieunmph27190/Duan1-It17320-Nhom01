package service;

import java.util.List;
import java.util.UUID;

import domain.Sole;

public interface SoleService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Sole entity) throws Exception;

	void insert(Sole entity) throws Exception;

	Sole findByID(UUID key);

	List<Sole> findAll(int first, int size);

	List<Sole> findAll();

    List<Sole> findByTypeEqual(int i);

    List<Sole> findByTypeNotEqual(int i);

    void setType(UUID id, int type) throws Exception;
	
}