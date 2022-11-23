package repository;

import java.util.UUID;

import domain.Brand;
import utils.JpaRespository;



public class BrandRepository extends JpaRespository<Brand, UUID>{

	public BrandRepository() {
		super(Brand.class);
	}
	
}