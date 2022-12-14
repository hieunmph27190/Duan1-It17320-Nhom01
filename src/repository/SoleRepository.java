package repository;

import domain.Category;
import java.util.UUID;

import domain.Sole;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;

public class SoleRepository extends JpaRespository<Sole, UUID> {

    public SoleRepository() {
        super(Sole.class);
    }

    public List<Sole> findByNameLike(String key) {
        String sql = "select c from Sole c where c.name like ?1 and type != 0";
        EntityManager en = JpaUtil.getEntityManager();
        TypedQuery<Sole> ty = en.createQuery(sql, Sole.class);
        ty.setParameter(1, key);

        return ty.getResultList();
    }

}
