package domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Promotion_Product database table.
 * 
 */
@Entity
@NamedQuery(name="Promotion_Product.findAll", query="SELECT p FROM Promotion_Product p")
public class Promotion_Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "genUUID")
	@GenericGenerator(name = "genUUID",strategy = "uuid2")
	private UUID id;

	@Column(name="Type")
	private Integer type;

	//bi-directional many-to-one association to ProductDetail
	@ManyToOne
	@JoinColumn(name="ProductDetailId")
	private ProductDetail productDetail;

	//bi-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name="PromotionId")
	private Promotion promotion;

	public Promotion_Product() {
	}
        @PrePersist@PreUpdate
       public void prePersistorUpdate(){
            if (type==null) {
                type=1;
            }
       }

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public ProductDetail getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Promotion) {
            Promotion promotion = (Promotion) obj;
            if (promotion.getId().toString().equals(this.getId().toString())) {
                return true;
            }
        }
        return false;
    }
        

}