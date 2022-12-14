package repository;

import java.util.UUID;

import domain.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;

public class EmployeeRepository extends JpaRespository<Employee, UUID> {

    public EmployeeRepository() {
        super(Employee.class);
    }

    public Employee findByUserName(String UserName) throws Exception {
        String sql = " Select e from Employee e Where username = :u and type != 0";
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Employee> qe = em.createQuery(sql, Employee.class);
        qe.setParameter("u", UserName);
        return qe.getSingleResult();

    }

    public Employee findByUserNamePassWord(String UserName, String PassWord) throws Exception {
        String sql = " Select e from Employee e Where username = :u and password = :p and type != 0";
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Employee> qe = em.createQuery(sql, Employee.class);
        qe.setParameter("u", UserName);
        qe.setParameter("p", PassWord);
        return qe.getSingleResult();

    }

    public void changePassword(UUID id, String newPass) throws Exception {
        String sql = "Update Employee set password = :newpass Where id = :id";
        EntityManager em = JpaUtil.getEntityManager();
        Query qe = em.createQuery(sql);
        qe.setParameter("newpass", newPass);
        qe.setParameter("id", id);
        try {
            em.getTransaction().begin();
            qe.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
    public List<Employee> getAlLNhanVien(){
        String jpql = " Select e from Employee e join e.role Where e.role.id = :i and e.type != 0";
        EntityManager em = JpaUtil.getEntityManager();
        Map<String,Object> map = new HashMap<>();
        map.put("i", UUID.fromString("7a1ab098-1f42-c54f-a2d7-59a460d318a3"));
        List<Employee> list= new ArrayList<Employee>();
        try {
            list = (List<Employee>) this.excuteQueryList(jpql, true,Employee.class , map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
