package repository;

import java.util.UUID;

import domain.Product;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utils.JpaRespository;
import utils.JpaUtil;

public class ProductRepository extends JpaRespository<Product, UUID> {

    public ProductRepository() {
        super(Product.class);
    }

    public Product FindByNameEqual(String name) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query.select(root);
        query.where(criteriaBuilder.equal(root.get("productName"), name));
        TypedQuery<Product> typedQuery = entityManager.createQuery(query);
        Product product = null;
        try {
            product = typedQuery.getSingleResult();
        } catch (NoResultException e) {

        }
        return product;
    }
}
