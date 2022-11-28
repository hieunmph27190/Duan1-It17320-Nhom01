package repository;

import java.util.UUID;

import domain.Employee;
import utils.JpaRespository;



public class EmployeeRepository extends JpaRespository<Employee, UUID>{

	public EmployeeRepository() {
		super(Employee.class);
	}

    public Employee findUserNamePassWord(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
}