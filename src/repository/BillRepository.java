package repository;

import java.util.UUID;

import domain.Bill;
import utils.JpaRespository;



public class BillRepository extends JpaRespository<Bill, UUID>{

	public BillRepository() {
		super(Bill.class);
	}
	
}