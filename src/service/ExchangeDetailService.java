package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.ExchangeDetail;

public interface ExchangeDetailService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(ExchangeDetail entity) throws Exception;

	void insert(ExchangeDetail entity) throws Exception;

	ExchangeDetail findByID(UUID key);

	List<ExchangeDetail> findAll(int first, int size);

	List<ExchangeDetail> findAll();

}