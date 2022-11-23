package repository;

import java.util.UUID;

import domain.ProductDetail;
import utils.JpaRespository;


public class ProductDetailRepository extends JpaRespository<ProductDetail, UUID>{

	public ProductDetailRepository() {
		super(ProductDetail.class);
	}
	
}