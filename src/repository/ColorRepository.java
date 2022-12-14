package repository;

import domain.Category;
import java.util.UUID;

import domain.Color;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;



public class ColorRepository extends JpaRespository<Color, UUID>{

	public ColorRepository() {
		super(Color.class);
	}
        
             public List<Color> findByNameLike(String key){
            String sql = "select c from Color c where c.colorName like ?1 and type != 0";
            EntityManager en = JpaUtil.getEntityManager();
            TypedQuery<Color> ty =  en.createQuery(sql, Color.class);
            ty.setParameter(1, key);
            
            return ty.getResultList();           
        }
	
}