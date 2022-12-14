package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Exchange;

public interface ExchangeService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Exchange entity) throws Exception;

	void insert(Exchange entity) throws Exception;

	Exchange findByID(UUID key);

	List<Exchange> findAll(int first, int size);

	List<Exchange> findAll();
	
}