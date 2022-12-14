package service;

import java.util.List;
import java.util.UUID;

import domain.Brand;

public interface BrandService {

    Long count();

    void remove(UUID key) throws Exception;

    void update(Brand entity) throws Exception;

    void insert(Brand entity) throws Exception;

    Brand findByID(UUID key);

    List<Brand> findAll(int first, int size);

    List<Brand> findAll();

    List<Brand> findByTypeEqual(int i);

    List<Brand> findByTypeNotEqual(int i);

    void setType(UUID id, int type) throws Exception;

    List<Brand> findByNameLike(String key);

}
