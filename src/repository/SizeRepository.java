package repository;

import java.util.UUID;

import domain.Size;
import utils.JpaRespository;


public class SizeRepository extends JpaRespository<Size, UUID>{

	public SizeRepository() {
		super(Size.class);
	}
	
}