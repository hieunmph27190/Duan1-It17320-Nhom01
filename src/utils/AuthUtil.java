package utils;

import domain.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

public class AuthUtil {

    static {
        user = null;
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
}
