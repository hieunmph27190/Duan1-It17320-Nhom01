package service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Exchange;
import repository.ExchangeRepository;
import service.ExchangeService;

public class ExchangeServiceImpl implements ExchangeService{
	private ExchangeRepository exchangeRepository;
	public ExchangeServiceImpl() {
		exchangeRepository = new ExchangeRepository();
	}
	@Override
	public List<Exchange> findAll() {
		return exchangeRepository.findAll();
	}
	@Override
	public List<Exchange> findAll(int first, int size) {
		return exchangeRepository.findAll(first, size);
	}
	@Override
	public Exchange findByID(UUID key) {
		return exchangeRepository.findByID(key);
	}
	@Override
	public void insert(Exchange entity) throws Exception {
		exchangeRepository.insert(entity);
	}
	@Override
	public void update(Exchange entity) throws Exception {
		exchangeRepository.update(entity);
	}
	@Override
	public void remove(UUID key) throws Exception {
		exchangeRepository.remove(key);
	}
	@Override
	public Long count() {
		return exchangeRepository.count();
	}
	
}