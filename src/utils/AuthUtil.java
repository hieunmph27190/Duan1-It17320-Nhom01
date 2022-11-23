package utils;

import domain.Employee;

public class AuthUtil {
	private static Employee employee;

	public static Employee getEmployee() {
		return employee;
	}

	public static void setEmployee(Employee employee) {
		AuthUtil.employee = employee;
	}

	public static boolean isNhanVien() {
		if (employee != null) {
			if (employee.getRole().equals("NV")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isQuanLi() {
		if (employee != null) {
			if (employee.getRole().equals("QL")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isLogin() {
		if (employee != null) {
			return true;
		}
		return false;
	}
}
