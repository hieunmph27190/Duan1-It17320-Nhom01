package service.impl;

import java.util.List;
import java.util.UUID;

import domain.ProductDetail;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import repository.ProductDetailRepository;
import service.ProductDetailService;
import utils.JpaUtil;

public class ProductDetailServiceImpl implements ProductDetailService {

    private ProductDetailRepository productDetailRepository;

    public ProductDetailServiceImpl() {
        productDetailRepository = new ProductDetailRepository();
    }

    @Override
    public List<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public List<ProductDetail> findAll(int first, int size) {
        return productDetailRepository.findAll(first, size);
    }

    @Override
    public ProductDetail findByID(UUID key) {
        return productDetailRepository.findByID(key);
    }

    @Override
    public void insert(ProductDetail entity) throws Exception {
        productDetailRepository.insert(entity);
    }

    @Override
    public void update(ProductDetail entity) throws Exception {
        productDetailRepository.update(entity);
    }

    @Override
    public void remove(UUID key) throws Exception {
        productDetailRepository.remove(key);
    }

    @Override
    public Long count() {
        return productDetailRepository.count();
    }

    public List<ProductDetail> findByTypeEqual(int i) {
        return productDetailRepository.findByTypeEqual(i);
    }

    public List<ProductDetail> findByTypeNotEqual(int i) {
        return productDetailRepository.findByTypeNotEqual(i);
    }

    public void setType(UUID id, int type) throws Exception {
        productDetailRepository.setType(id, type);
    }

    @Override
    public List<ProductDetail> searchProductDetail(String productName, String category, String color, String size, String brand, String soles, String amount, String price) {
        return productDetailRepository.searchProductDetail(productName, category, color, size, brand, soles, amount, price);
    }

    @Override
    public void changeAmount(UUID id, Integer amountChange) throws Exception {
        productDetailRepository.changeAmount(id, amountChange);
    }

}
