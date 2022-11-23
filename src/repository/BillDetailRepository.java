package repository;

import java.util.UUID;

import domain.BillDetail;
import utils.JpaRespository;

public class BillDetailRepository extends JpaRespository<BillDetail, UUID>{

	public BillDetailRepository() {
		super(BillDetail.class);
	}
	
}