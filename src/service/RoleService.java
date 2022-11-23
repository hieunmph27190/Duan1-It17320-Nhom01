package service;

import java.util.List;
import java.util.UUID;

import domain.Role;

public interface RoleService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Role entity) throws Exception;

	void insert(Role entity) throws Exception;

	Role findByID(UUID key);

	List<Role> findAll(int first, int size);

	List<Role> findAll();

    List<Role> findByTypeEqual(int i);

    List<Role> findByTypeNotEqual(int i);

    void setType(UUID id, int type) throws Exception;
	
}