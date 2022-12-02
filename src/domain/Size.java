package domain;

import java.io.Serializable;
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

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the Size database table.
 *
 */
@Entity
@NamedQuery(name = "Size.findAll", query = "SELECT s FROM Size s")
public class Size implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "genUUID")
    @GenericGenerator(name = "genUUID", strategy = "uuid2")
    private UUID id;

    @Column(name = "Code")
    private String code;

    @Column(name = "Size")
    private Integer size;

    @Column(name = "Type")
    private Integer type;

    //bi-directional many-to-one association to ProductDetail
    @OneToMany(mappedBy = "size")
    private List<ProductDetail> productDetails;

    public Size() {
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<ProductDetail> getProductDetails() {
        return this.productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public ProductDetail addProductDetail(ProductDetail productDetail) {
        getProductDetails().add(productDetail);
        productDetail.setSize(this);

        return productDetail;
    }

    public ProductDetail removeProductDetail(ProductDetail productDetail) {
        getProductDetails().remove(productDetail);
        productDetail.setSize(null);

        return productDetail;
    }

    @Override
    public String toString() {
        return size + "";
    }

}
