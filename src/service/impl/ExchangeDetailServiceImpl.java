package service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.ExchangeDetail;
import repository.ExchangeDetailRepository;
import service.ExchangeDetailService;

public class ExchangeDetailServiceImpl implements ExchangeDetailService {
	private ExchangeDetailRepository exchangeDetailRepository;

	public ExchangeDetailServiceImpl() {
		exchangeDetailRepository = new ExchangeDetailRepository();
	}



	@Override
	public List<ExchangeDetail> findAll() {
		return exchangeDetailRepository.findAll();
	}

	@Override
	public List<ExchangeDetail> findAll(int first, int size) {
		return exchangeDetailRepository.findAll(first, size);
	}

	@Override
	public ExchangeDetail findByID(UUID key) {
		return exchangeDetailRepository.findByID(key);
	}

	@Override
	public void insert(ExchangeDetail entity) throws Exception {
		exchangeDetailRepository.insert(entity);
	}

	@Override
	public void update(ExchangeDetail entity) throws Exception {
		exchangeDetailRepository.update(entity);
	}

	@Override
	public void remove(UUID key) throws Exception {
		exchangeDetailRepository.remove(key);
	}

	@Override
	public Long count() {
		return exchangeDetailRepository.count();
	}

}