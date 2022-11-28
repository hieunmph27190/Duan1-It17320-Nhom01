package repository;

import java.util.UUID;

import domain.ProductDetail;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;

public class ProductDetailRepository extends JpaRespository<ProductDetail, UUID> {

    public ProductDetailRepository() {
        super(ProductDetail.class);
    }

    public void changeAmount(UUID id, Integer amountChange) throws Exception {
        String jpql = "update ProductDetail set amount = :amount where id = :id";
        EntityManager entityManager = JpaUtil.getEntityManager();
        ProductDetail productDetail = entityManager.find(ProductDetail.class, id);
        Long newAmount = productDetail.getAmount() + amountChange;
        try {
            Query query=    entityManager.createQuery(jpql);
            query.setParameter("amount", newAmount);
            query.setParameter("id", id);
            entityManager.getTransaction().begin();
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
