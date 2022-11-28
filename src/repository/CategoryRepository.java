package repository;

import java.util.UUID;

import domain.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;

public class CategoryRepository extends JpaRespository<Category, UUID> {

    public CategoryRepository() {
        super(Category.class);
    }

    public List<Category> findByNameLike(String key) {
        String sql = "select c from Category c where c.name like ?1 and type != 0";
        EntityManager en = JpaUtil.getEntityManager();
        TypedQuery<Category> ty = en.createQuery(sql, Category.class);
        ty.setParameter(1, key);

        return ty.getResultList();
    }

}
