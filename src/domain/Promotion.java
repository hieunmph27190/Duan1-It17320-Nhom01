package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the Promotion database table.
 *
 */
@Entity
@NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "genUUID")
    @GenericGenerator(name = "genUUID", strategy = "uuid2")
    private UUID id;

    @Column(name = "Description")
    private String description;

    @Column(name = "Discount")
    private Double discount;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "MinimumPrice")
    private BigDecimal minimumPrice;

    @Column(name = "PromotionName")
    private String promotionName;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "Type")
    private Integer type;

    //bi-directional many-to-one association to Promotion_Product
    @OneToMany(mappedBy = "promotion")
    @Cascade({CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Promotion_Product> promotionProducts;

    public Promotion() {
    }
    @PrePersist
    @PreUpdate
    public void prePersistorUpdate() {
        if (type == null) {
            type = 1;
        }
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getMinimumPrice() {
        return this.minimumPrice;
    }

    public void setMinimumPrice(BigDecimal minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public String getPromotionName() {
        return this.promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Promotion_Product> getPromotionProducts() {
        return this.promotionProducts;
    }

    public void setPromotionProducts(List<Promotion_Product> promotionProducts) {
        this.promotionProducts = promotionProducts;
    }

    public Promotion_Product addPromotionProduct(Promotion_Product promotionProduct) {
        getPromotionProducts().add(promotionProduct);
        promotionProduct.setPromotion(this);

        return promotionProduct;
    }

    public Promotion_Product removePromotionProduct(Promotion_Product promotionProduct) {
        getPromotionProducts().remove(promotionProduct);
        promotionProduct.setPromotion(null);

        return promotionProduct;
    }

    public String getTrangThai() {
        Date date = new Date();
        if (date.before(startDate)) {
            return "Chua ap dung";
        } else {
            if (date.after(endDate)) {
                return "Ngung ap dung";
            } else {
                return "Dang ap dung";
            }
        }
    }

    public Object[] toRow() {
        return new Object[]{
            id,promotionName,type,minimumPrice,discount,getTrangThai()
        };
    }

}
