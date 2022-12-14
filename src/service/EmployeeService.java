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

        
   

    void changePassword(UUID id, String newPass) throws Exception;

    Employee findByUserName(String UserName) throws Exception;

    Employee findByUserNamePassWord(String UserName, String PassWord) throws Exception;

    List<Employee> getAlLNhanVien();
}
