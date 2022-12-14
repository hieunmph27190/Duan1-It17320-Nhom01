package service;

import domain.Bill;
import domain.BillDetail;
import domain.ProductDetail;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface BillDetailService {

    Long count();

    List<BillDetail> findAll();

    List<BillDetail> findAll(int first, int size);

    BillDetail findByID(UUID key);

    void insert(BillDetail entity) throws Exception;

    void remove(UUID key) throws Exception;

    void update(BillDetail entity) throws Exception;

    List<BillDetail> findByBill(Bill bill);

   
    Boolean containsProductDetail(Bill bill, ProductDetail productDetail);
	
}