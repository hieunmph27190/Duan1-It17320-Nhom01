package repository;

import domain.Color;
import java.util.UUID;

import domain.ProductDetail;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.Constant;
import utils.JpaRespository;
import utils.JpaUtil;

public class ProductDetailRepository extends JpaRespository<ProductDetail, UUID> {

    public ProductDetailRepository() {
        super(ProductDetail.class);
    }

    public List<ProductDetail> searchProductDetail(String productName, String category, String color, String size, String brand) {
        Map<Integer, Object> mapParam = new HashMap<>();
        int indexParam = 1;
        //        String sql = "select c from Color c where c.name like ?1 and type != 0";
        //        EntityManager en = JpaUtil.getEntityManager();
        //        TypedQuery<ProductDetail> ty = en.createQuery(sql, ProductDetail.class);
        //        ty.setParameter(1, value);
        //        return ty.getResultList();

        StringBuffer querySql = new StringBuffer();
        querySql.append("SELECT p FROM ProductDetail p WHERE 1=1 ");
        if (!"".equals(productName)) {
            querySql.append(" AND p.product.productName ");
            int index = indexParam++;
            querySql.append(" LIKE ?" + index);
            mapParam.put(index, "%" + productName + "%");
        }

        if (!"".equals(category)) {
            querySql.append(" AND p.category.name ");
            int index = indexParam++;
            querySql.append(" LIKE ?" + index);
            mapParam.put(index, "%" + category + "%");
        }

        if (!"".equals(color)) {
            querySql.append(" AND p.color.colorName");
            int index = indexParam++;
            querySql.append(" LIKE ?" + index);
            mapParam.put(index, "%" + color + "%");
        }

        if (!"".equals(size)) {
            try {
                Integer.parseInt(size);
                querySql.append(" AND p.size.size");
                int index = indexParam++;
                querySql.append(" = ?" + index);
                mapParam.put(index, Integer.parseInt(size));
            } catch (Exception e) {
            }
        }

        if (!"".equals(brand)) {
            querySql.append(" AND p.brand.name");
            int index = indexParam++;
            querySql.append(" LIKE ?" + index);
            mapParam.put(index, "%" + brand + "%");
        }

        System.out.println(querySql.toString());
//        querySql.append(" LIKE ?1");
        EntityManager en = JpaUtil.getEntityManager();
        TypedQuery<ProductDetail> ty = en.createQuery(querySql.toString(), ProductDetail.class);
        if (mapParam != null) {
            for (Integer key : mapParam.keySet()) {
                ty.setParameter(key, mapParam.get(key));
            }
        }
        return ty.getResultList();
    }

}
