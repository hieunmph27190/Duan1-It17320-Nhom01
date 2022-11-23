package repository;

import java.util.UUID;

import domain.Sole;
import utils.JpaRespository;



public class SoleRepository extends JpaRespository<Sole, UUID>{

	public SoleRepository() {
		super(Sole.class);
	}
	
}