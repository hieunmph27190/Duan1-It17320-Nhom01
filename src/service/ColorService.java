package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Color;

public interface ColorService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Color entity) throws Exception;

	void insert(Color entity) throws Exception;

	Color findByID(UUID key);

	List<Color> findAll(int first, int size);

	List<Color> findAll();

    List<Color> findByTypeEqual(int i);

    List<Color> findByTypeNotEqual(int i);

    void setType(UUID id, int type) throws Exception;

}