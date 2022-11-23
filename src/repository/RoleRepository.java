package repository;

import java.util.UUID;

import domain.Role;
import utils.JpaRespository;



public class RoleRepository extends JpaRespository<Role, UUID>{

	public RoleRepository() {
		super(Role.class);
	}
	
}