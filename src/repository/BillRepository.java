package repository;

import java.util.UUID;

import domain.Bill;
import domain.ProductDetail;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;

public class BillRepository extends JpaRespository<Bill, UUID> {

    public BillRepository() {
        super(Bill.class);
    }

    public BigDecimal getSumMoney(Bill bill) {
        String jpql = "select sum(bx.price*bx.quantity) from Bill b join b.billDetails bx where b.id = :id";
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        query.setParameter("id", bill.getId());
        BigDecimal sum = query.getSingleResult();
        return sum;
    }

    public Long getQuantity(Bill bill) {
        String jpql = "select sum(bx.quantity) from Bill b join b.billDetails bx where b.id = :id";
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("id", bill.getId());
        Long sum = query.getSingleResult();
        return sum;
    }

    public List<Bill> searchcbb(String custormername, String empolyname,Date startDate,Date endDate,Integer type) {
        String jdql = "Select B from Bill B inner join B.customer join B.employee where B.customer.firstName+' '+B.customer.bufferName+' '+B.customer.name like :fullcustomor and B.employee.firstName+' '+B.employee.bufferName+' '+B.employee.name like :fullempolyname and createDate>=:startDate and createDate<=:endDate ";
        if (type!=null) {
           jdql+=" and B.type=:type"; 
        }
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Bill> query = em.createQuery(jdql, Bill.class);
        query.setParameter("fullcustomor", "%" + custormername + "%");
        query.setParameter("fullempolyname", "%" + empolyname + "%");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        if (type!=null) {
           query.setParameter("type", type);
        }
        List<Bill> lisst = query.getResultList();
        return lisst;
    }

}
