package service.impl;

import domain.Bill;
import domain.BillDetail;
import domain.ProductDetail;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import repository.BillDetailRepository;
import service.BillDetailService;

public class BillDetailServiceImpl implements BillDetailService {

    private BillDetailRepository billDetailRepository;

    public BillDetailServiceImpl() {
        billDetailRepository = new BillDetailRepository();
    }


    public List<BillDetail> findAll() {
        return billDetailRepository.findAll();
    }

    public List<BillDetail> findAll(int first, int size) {
        return billDetailRepository.findAll(first, size);
    }

    public BillDetail findByID(UUID key) {
        return billDetailRepository.findByID(key);
    }

    public void insert(BillDetail entity) throws Exception {
        billDetailRepository.insert(entity);
    }

    public void update(BillDetail entity) throws Exception {
        billDetailRepository.update(entity);
    }

    public void remove(UUID key) throws Exception {
        billDetailRepository.remove(key);
    }

    public List<BillDetail> findByBill(Bill bill) {
        return billDetailRepository.findByBill(bill);
    }

    public Long count() {
        return billDetailRepository.count();
    }

    public Boolean containsProductDetail(Bill bill ,ProductDetail productDetail) {
        return billDetailRepository.containsProductDetail(bill, productDetail);
    }
    
}
