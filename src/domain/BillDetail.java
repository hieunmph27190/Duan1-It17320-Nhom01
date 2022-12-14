package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the BillDetails database table.
 *
 */
@Entity
@Table(name = "BillDetails")
@NamedQuery(name = "BillDetail.findAll", query = "SELECT b FROM BillDetail b")
public class BillDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "genUUID")
    @GenericGenerator(name = "genUUID", strategy = "uuid2")
    private UUID id;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Type")
    private Integer type;

    //bi-directional many-to-one association to Bill
    @ManyToOne
    @JoinColumn(name = "BillId")
    private Bill bill;

    //bi-directional many-to-one association to ProductDetail
    @ManyToOne
    @JoinColumn(name = "ProductDetailId")
    private ProductDetail productDetail;

    public BillDetail() {
    }

    @PrePersist
    public void pre() {
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

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Bill getBill() {
        return this.bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public ProductDetail getProductDetail() {
        return this.productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BillDetail) {
            BillDetail billDetail = (BillDetail) obj;            
            if (this.getId().toString().equals(billDetail.getId().toString())) {
                return true;
            }
        }

        return false;
    }
    

}
