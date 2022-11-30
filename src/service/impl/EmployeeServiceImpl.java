package service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl() {
		employeeRepository = new EmployeeRepository();
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findAll(int first, int size) {
		return employeeRepository.findAll(first, size);
	}

	@Override
	public Employee findByID(UUID key) {
		return employeeRepository.findByID(key);
	}

	@Override
	public void insert(Employee entity) throws Exception {
		employeeRepository.insert(entity);
	}

	@Override
	public void update(Employee entity) throws Exception {
		employeeRepository.update(entity);
	}

	@Override
	public void remove(UUID key) throws Exception {
		employeeRepository.remove(key);
	}

	@Override
	public Long count() {
		return employeeRepository.count();
	}

    public Employee findByUserName(String UserName) throws Exception {
        return employeeRepository.findByUserName(UserName);
    }
        
    

   

    public void changePassword(UUID id, String newPass) throws Exception {
        employeeRepository.changePassword(id, newPass);
    }

    public Employee findByUserNamePassWord(String UserName, String PassWord) throws Exception {
        return employeeRepository.findByUserNamePassWord(UserName, PassWord);
    }
}