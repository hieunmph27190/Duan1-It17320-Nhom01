package repository;

import java.util.UUID;

import domain.Employee;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;

public class EmployeeRepository1 extends JpaRespository<Employee, UUID> {

    public EmployeeRepository1() {
        super(Employee.class);
    }

    public Employee findUserNamePassWord(String username,String password) {
        String sql = "select e from Employee e where username = :u and password = :p ";
        EntityManager entityManager = JpaUtil.getEntityManager();
        TypedQuery<Employee> query =  entityManager.createQuery(sql, Employee.class);
        query.setParameter("u", username);
        query.setParameter("p", password);
        Employee employee = null;
        try {
              employee = query.getSingleResult();
             
        } catch (NoResultException e) {
        }
        
        return employee;
    }
}
