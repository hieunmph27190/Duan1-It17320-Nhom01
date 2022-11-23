package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Employee;

public interface EmployeeService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Employee entity) throws Exception;

	void insert(Employee entity) throws Exception;

	Employee findByID(UUID key);

	List<Employee> findAll(int first, int size);

	List<Employee> findAll();

}