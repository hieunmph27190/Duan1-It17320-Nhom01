package service;

import domain.Bill;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface BillService {

    Long count();

    List<Bill> findAll();

    List<Bill> findAll(int first, int size);

    Bill findByID(UUID key);

    void insert(Bill entity) throws Exception;

    void remove(UUID key) throws Exception;

    void update(Bill entity) throws Exception;
	
}