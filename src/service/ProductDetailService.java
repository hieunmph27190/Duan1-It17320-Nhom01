package service;

import java.util.List;
import java.util.UUID;

import domain.ProductDetail;
import java.math.BigDecimal;

public interface ProductDetailService {

    Long count();

    void remove(UUID key) throws Exception;

    void update(ProductDetail entity) throws Exception;

    void insert(ProductDetail entity) throws Exception;

    ProductDetail findByID(UUID key);

    List<ProductDetail> findAll(int first, int size);

    List<ProductDetail> findAll();

    List<ProductDetail> findByTypeEqual(int i);

    List<ProductDetail> findByTypeNotEqual(int i);

    void setType(UUID id, int type) throws Exception;


    List<ProductDetail> searchProductDetail(String productName, String category, String color, String size, String brand, String soles, String amount, String price);


    void changeAmount(UUID id, Integer amountChange) throws Exception;

    

	
}

