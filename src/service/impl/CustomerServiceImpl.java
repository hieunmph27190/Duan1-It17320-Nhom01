package service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Customer;
import repository.CustomerRepository;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;

        
    public List<Customer> getKHDelete() {
        return customerRepository.getKHDelete();
    }

    public List<Customer> getKH() {
        return customerRepository.getKH();
    }
    

    
    public void setType(UUID id, int type) throws Exception {
        customerRepository.setType(id, type);
    }
    
    
    
	public CustomerServiceImpl() {
		customerRepository=new CustomerRepository();
	}
        
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
        
	@Override
	public List<Customer> findAll(int first, int size) {
		return customerRepository.findAll(first, size);
	}
        
	@Override
	public Customer findByID(UUID key) {
		return customerRepository.findByID(key);
	}
        
	@Override
	public void insert(Customer entity) throws Exception {
		customerRepository.insert(entity);
	}
        
	@Override
	public void update(Customer entity) throws Exception {
		customerRepository.update(entity);
	}
        
	@Override
	public void remove(UUID key) throws Exception {
		customerRepository.remove(key);
	}
        
	@Override
	public Long count() {
		return customerRepository.count();
	}

    public Customer findBySDT(String sdt) {
        return customerRepository.findBySDT(sdt);
    }
        
	
}