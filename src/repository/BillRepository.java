package repository;

import java.util.UUID;

import domain.Bill;
import domain.ProductDetail;
import java.math.BigDecimal;
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

}
