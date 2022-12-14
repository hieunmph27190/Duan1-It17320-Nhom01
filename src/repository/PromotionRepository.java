package repository;

import java.util.UUID;

import domain.Promotion;
import java.util.ArrayList;
import java.util.List;
import utils.JpaRespository;

public class PromotionRepository extends JpaRespository<Promotion, UUID> {

    public PromotionRepository() {
        super(Promotion.class);
    }

    public List<Promotion> loc(Integer loai, Integer trangThai) {
        String jpql = "SELECT * FROM dbo.Promotion ";
        boolean where = false;

        if (loai != null) {
            if (!where) {
                jpql += " WHERE ";
                where = true;
                
            }else{
                jpql += " AND ";
            }
            jpql += " Type = "+loai+' ';
        }
        if (trangThai != null) {
            if (!where) {
                jpql += " WHERE ";
                where = true;
                
            }else{
                jpql += " AND ";
            }
            if (trangThai == 1) {
                jpql += " GETDATE()>=EndDate ";
            }else if (trangThai == 2) {
                jpql += " GETDATE()<=EndDate and GETDATE()>=StartDate";
            } else if (trangThai == 3) {
                jpql += " GETDATE()<=StartDate ";
            }
        }
        List<Promotion> list = new ArrayList<>();
        try {
            list = (List<Promotion>)  excuteQueryList(jpql, false, Promotion.class, null);
            return   list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
                
                
    }

}
