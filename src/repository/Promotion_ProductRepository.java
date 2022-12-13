package repository;

import domain.Product;
import domain.ProductDetail;
import domain.Promotion;
import java.util.UUID;

import domain.Promotion_Product;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utils.JpaRespository;
import utils.JpaUtil;

public class Promotion_ProductRepository extends JpaRespository<Promotion_Product, UUID> {

    public Promotion_ProductRepository() {
        super(Promotion_Product.class);
    }

    public Promotion_Product findByProductAndPromotion(ProductDetail d, Promotion p) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Promotion_Product> query = criteriaBuilder.createQuery(Promotion_Product.class);
        Root root = query.from(Promotion_Product.class);
        query.select(root);
        query.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("productDetail"), d),criteriaBuilder.equal(root.get("promotion"), p)));
        TypedQuery<Promotion_Product> typedQuery = entityManager.createQuery(query);
        Promotion_Product promotion_Product = null;
        try {
            promotion_Product = typedQuery.getSingleResult();
        } catch (NoResultException e) {

        }
        return promotion_Product;
    }
    public void deletePromotionNull(){
        String jpql = "delete Promotion_Product where promotion is null";
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            
            entityManager.getTransaction().begin();
            entityManager.createQuery(jpql).executeUpdate();
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
//            entityManager.close();
        }
    }

}
