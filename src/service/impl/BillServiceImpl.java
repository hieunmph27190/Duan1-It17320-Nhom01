package service.impl;

import domain.Bill;
import domain.ProductDetail;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import repository.BillRepository;
import service.BillService;

public class BillServiceImpl implements BillService {

    private BillRepository billRepository;

    public BillServiceImpl() {
        billRepository = new BillRepository();
    }

    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    public List<Bill> findAll(int first, int size) {
        return billRepository.findAll(first, size);
    }

    public Bill findByID(UUID key) {
        return billRepository.findByID(key);
    }

    public void insert(Bill entity) throws Exception {
        billRepository.insert(entity);
    }

    public void update(Bill entity) throws Exception {
        billRepository.update(entity);
    }

    public void remove(UUID key) throws Exception {
        billRepository.remove(key);
    }

    public Long count() {
        return billRepository.count();
    }

    public List<Bill> findByTypeEqual(int i) {
        return billRepository.findByTypeEqual(i);
    }

    public List<Bill> findByTypeNotEqual(int i) {
        return billRepository.findByTypeNotEqual(i);
    }

    public void setType(UUID id, int type) throws Exception {
        billRepository.setType(id, type);
    }

    public BigDecimal getSumMoney(Bill bill) {
        return billRepository.getSumMoney(bill);
    }

    public Long getQuantity(Bill bill) {
        return billRepository.getQuantity(bill);
    }

    public List<Bill> search(String custormername, String empolyname, Date startDate, Date endDate, Integer type) {
        return billRepository.searchcbb(custormername, empolyname, startDate, endDate, type);
    }

   

}
