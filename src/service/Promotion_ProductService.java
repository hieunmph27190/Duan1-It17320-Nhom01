package service;

import domain.ProductDetail;
import domain.Promotion;
import java.util.List;
import java.util.UUID;

import domain.Promotion_Product;

public interface Promotion_ProductService {

	Long count();

	void remove(UUID key) throws Exception;

	void update(Promotion_Product entity) throws Exception;

	void insert(Promotion_Product entity) throws Exception;

	Promotion_Product findByID(UUID key);

	List<Promotion_Product> findAll(int first, int size);

	List<Promotion_Product> findAll();

    Promotion_Product findByProductAndPromotion(ProductDetail d, Promotion p);

    void deletePromotionNull();
	
}