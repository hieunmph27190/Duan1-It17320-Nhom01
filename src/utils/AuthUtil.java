package utils;

import domain.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

public class AuthUtil {
    static {
        user = new EmployeeServiceImpl().findAll().get(0);
    }
	private static Object user;

	public static Employee getEmployee() {
        if (user instanceof  Employee) {
            return (Employee) user;
        }
		return null;
	}

	public static void setEmployee(Employee employee) {
		AuthUtil.user = employee;
	}

	

	

	public static boolean isLogin() {
		if (user != null) {
			return true;
		}
		return false;
	}
}
