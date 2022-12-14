package repository;

import domain.Color;
import java.util.UUID;

import domain.ProductDetail;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.Constant;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import utils.JpaRespository;
import utils.JpaUtil;

public class ProductDetailRepository extends JpaRespository<ProductDetail, UUID> {

    public ProductDetailRepository() {
        super(ProductDetail.class);
    }

    public Double getKM(UUID id) {
        String sql = "SELECT IIF(EXISTS (SELECT SUM(Discount) FROM dbo.Promotion WHERE GETDATE()>=StartDate AND GETDATE()<=EndDate AND Type =2),(SELECT SUM(Discount) FROM dbo.Promotion WHERE GETDATE()>=StartDate AND GETDATE()<=EndDate AND Type =2),0) + IIF(EXISTS (SELECT SUM(Discount) FROM dbo.ProductDetail JOIN dbo.Promotion_Product ON Promotion_Product.ProductDetailId = ProductDetail.Id\n"
                + "								JOIN dbo.Promotion ON Promotion.Id = Promotion_Product.PromotionId\n"
                + "								WHERE GETDATE()>=StartDate AND GETDATE()<=EndDate AND Promotion.Type =1 AND dbo.ProductDetail.Type !=0 AND ProductDetail.Id =:id),(SELECT SUM(Discount) FROM dbo.ProductDetail JOIN dbo.Promotion_Product ON Promotion_Product.ProductDetailId = ProductDetail.Id\n"
                + "								JOIN dbo.Promotion ON Promotion.Id = Promotion_Product.PromotionId\n"
                + "								WHERE GETDATE()>=StartDate AND GETDATE()<=EndDate AND Promotion.Type =1 AND dbo.ProductDetail.Type !=0 AND ProductDetail.Id =:id),0)";
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        EntityManager en = JpaUtil.getEntityManager();
        Query q = en.createNativeQuery(sql);
        q.setParameter("id", id);

        try {
            Double giamgia = (Double) q.getSingleResult();
            if (giamgia == null) {
                giamgia = 0D;
            }
            return giamgia;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0D;
        }
    }

    public List<ProductDetail> searchProductDetail(String productName, String category, String color, String size, String brand, String soles, String amount, String price) {
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

        if (!"".equals(soles)) {
            querySql.append(" AND p.sole.name");
            int index = indexParam++;
            querySql.append(" LIKE ?" + index);
            mapParam.put(index, "%" + soles + "%");
        }

        if (!"".equals(amount)) {
            try {
                Long.parseLong(amount);
                querySql.append(" AND p.amount");
                int index = indexParam++;
                querySql.append(" = ?" + index);
                mapParam.put(index, Long.parseLong(amount));
            } catch (Exception e) {
            }
        }

        if (!"".equals(price)) {
            try {
                new BigDecimal(price);
                querySql.append(" AND p.price");
                int index = indexParam++;
                querySql.append(" = ?" + index);
                mapParam.put(index, new BigDecimal(price));
            } catch (Exception e) {
            }
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

    public void changeAmount(UUID id, Integer amountChange) throws Exception {
        String jpql = "update ProductDetail set amount = :amount where id = :id";
        EntityManager entityManager = JpaUtil.getEntityManager();
        ProductDetail productDetail = entityManager.find(ProductDetail.class, id);
        Long newAmount = productDetail.getAmount() + amountChange;
        if (newAmount < 0) {
            throw new Exception("So luong khong du");
        }
        try {
            Query query = entityManager.createQuery(jpql);
            query.setParameter("amount", newAmount);
            query.setParameter("id", id);
            entityManager.getTransaction().begin();
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

}
