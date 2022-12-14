package utils;

import domain.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

public class AuthUtil {

    static {
        user = new EmployeeServiceImpl().findAll().get(0);
    }
    private static Employee user;

    public static Employee getEmployee() {
        return user;
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
    public static boolean isNhanVien() {
        if (user != null) {
        	if (user.getRole().getCode().equalsIgnoreCase("nv")) {
				return true;
			}
          
        }
        return false;
    }
    public static boolean isQuanLi() {
        if (user != null) {
        	if (user.getRole().getCode().equalsIgnoreCase("ql")) {
				return true;
			}
          
        }
        return false;
    }
}
