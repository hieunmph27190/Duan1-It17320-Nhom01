package repository;

import domain.Bill;
import java.util.UUID;

import domain.BillDetail;
import domain.ProductDetail;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utils.JpaRespository;
import utils.JpaUtil;

public class BillDetailRepository extends JpaRespository<BillDetail, UUID> {

    public BillDetailRepository() {
        super(BillDetail.class);
    }

    public List<BillDetail> findByBill(Bill bill) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BillDetail> query = criteriaBuilder.createQuery(BillDetail.class);
        Root root = query.from(BillDetail.class);
        query.select(root);
        query.where(criteriaBuilder.equal(root.get("bill"), bill));
        TypedQuery<BillDetail> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public Boolean containsProductDetail(Bill bill, ProductDetail productDetail) {
        String jpql = "Select count(b) from BillDetail b where b.productDetail.id = :prod and b.bill.id = :id";
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("prod", productDetail.getId());
        query.setParameter("id", bill.getId());
        Long a = query.getSingleResult();
        return a > 0;
    }

}
