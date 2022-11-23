package service.impl;


import domain.Bill;
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
	
}