package repository;

import java.util.UUID;

import domain.Brand;
import domain.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;

public class BrandRepository extends JpaRespository<Brand, UUID> {

    public BrandRepository() {
        super(Brand.class);
    }

    public List<Brand> findByNameLike(String key) {

        String sql = "select c from Brand c where c.name like ?1 and type != 0";

        EntityManager en = JpaUtil.getEntityManager();
        TypedQuery<Brand> ty = en.createQuery(sql, Brand.class);
        ty.setParameter(1, key);

        return ty.getResultList();
        
        
        
    }
}
