package repository;

import java.util.UUID;

import domain.Exchange;
import utils.JpaRespository;


public class ExchangeRepository extends JpaRespository<Exchange, UUID>{

	public ExchangeRepository() {
		super(Exchange.class);
	}
	
}