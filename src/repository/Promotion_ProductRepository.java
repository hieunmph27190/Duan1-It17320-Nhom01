package repository;

import java.util.UUID;

import domain.Promotion_Product;
import utils.JpaRespository;

public class Promotion_ProductRepository extends JpaRespository<Promotion_Product, UUID>{

	public Promotion_ProductRepository() {
		super(Promotion_Product.class);
	}
	
}