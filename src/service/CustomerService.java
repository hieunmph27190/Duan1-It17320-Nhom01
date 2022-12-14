package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Customer;

public interface CustomerService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Customer entity) throws Exception;

	void insert(Customer entity) throws Exception;

	Customer findByID(UUID key);

	List<Customer> findAll(int first, int size);

	List<Customer> findAll();

        List<Customer> getKHDelete();

        void setType(UUID id, int type) throws Exception;

    List<Customer> getKH();

    Customer findBySDT(String sdt);
	
}