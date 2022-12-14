package repository;

import domain.Category;
import java.util.UUID;

import domain.Size;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;


public class SizeRepository extends JpaRespository<Size, UUID>{

	public SizeRepository() {
		super(Size.class);
	}
             public List<Size> findByNameLike(String key){
            String sql = "select c from Size c where c.size like ?1 and type != 0";
            EntityManager en = JpaUtil.getEntityManager();
            TypedQuery<Size> ty =  en.createQuery(sql, Size.class);
            ty.setParameter(1, key);
            
            return ty.getResultList();           
        }
        
	
}