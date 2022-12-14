package repository;

import java.util.UUID;

import domain.Promotion;
import utils.JpaRespository;



public class PromotionRepository extends JpaRespository<Promotion, UUID>{

	public PromotionRepository() {
		super(Promotion.class);
	}
	
}