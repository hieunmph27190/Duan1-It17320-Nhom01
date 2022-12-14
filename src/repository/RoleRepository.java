package repository;

import domain.Category;
import java.util.UUID;

import domain.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaRespository;
import utils.JpaUtil;



public class RoleRepository extends JpaRespository<Role, UUID>{

	public RoleRepository() {
		super(Role.class);
	}
        
    public List<Role> findByNameLike(String key){
            String sql = "select c from Role c where c.name like ?1 and type != 0";
            EntityManager en = JpaUtil.getEntityManager();
            TypedQuery<Role> ty =  en.createQuery(sql, Role.class);
            ty.setParameter(1, key);
            
            return ty.getResultList();           
        }
	
}