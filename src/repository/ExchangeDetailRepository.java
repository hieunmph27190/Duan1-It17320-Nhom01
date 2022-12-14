package repository;

import java.util.UUID;

import domain.ExchangeDetail;
import utils.JpaRespository;



public class ExchangeDetailRepository extends JpaRespository<ExchangeDetail, UUID>{

	public ExchangeDetailRepository() {
		super(ExchangeDetail.class);
	}
	
}