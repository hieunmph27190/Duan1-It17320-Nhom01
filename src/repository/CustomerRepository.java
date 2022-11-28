package repository;

import java.util.UUID;

import domain.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utils.JpaRespository;
import utils.JpaUtil;

public class CustomerRepository extends JpaRespository<Customer, UUID> {

    public CustomerRepository() {
        super(Customer.class);
    }

    public List<Customer> getKHDelete() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        Root root = query.from(Customer.class);
        query.select(root);
        query.where(criteriaBuilder.equal(root.get("type"), 0));
        TypedQuery<Customer> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    
    public void setType(UUID id, int type) throws Exception{
        EntityManager entityManager = JpaUtil.getEntityManager();
        String sql = "Update Customer set type=?2 where id = ?1";
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, id);
        query.setParameter(2, type);
        try {
            entityManager.getTransaction().begin();
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
             throw e;
        }

    }
    
    
        public List<Customer> getKH() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        Root root = query.from(Customer.class);
        query.select(root);
        query.where(criteriaBuilder.notEqual(root.get("type"), 0));
        TypedQuery<Customer> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
        
    public Customer findBySDT(String sdt){
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        Root root = query.from(Customer.class);
        query.select(root);
        query.where(criteriaBuilder.equal(root.get("phoneNumber"), sdt));
        TypedQuery<Customer> typedQuery = entityManager.createQuery(query);
        Customer customer = null;
        try {
            customer = typedQuery.getSingleResult();
        } catch (Exception e) {
        }
        return customer;
    }
    

}
