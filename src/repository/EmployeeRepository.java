package repository;

import java.util.UUID;

import domain.Employee;
import utils.JpaRespository;



public class EmployeeRepository extends JpaRespository<Employee, UUID>{

	public EmployeeRepository() {
		super(Employee.class);
	}
	
}