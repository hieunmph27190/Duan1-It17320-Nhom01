package service;

import domain.Bill;
import domain.ProductDetail;
import java.math.BigDecimal;
import java.util.Date;
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

    List<Bill> findByTypeEqual(int i);

    List<Bill> findByTypeNotEqual(int i);

    void setType(UUID id, int type) throws Exception;

    BigDecimal getSumMoney(Bill bill);

    Long getQuantity(Bill bill);

    List<Bill> search(String custormername, String empolyname, Date startDate, Date endDate, Integer type);

}
