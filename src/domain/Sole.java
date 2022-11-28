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
 * The persistent class for the Sole database table.
 * 
 */
@Entity
@NamedQuery(name="Sole.findAll", query="SELECT s FROM Sole s")
public class Sole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "genUUID")
	@GenericGenerator(name = "genUUID",strategy = "uuid2")
	@Column(name="Id")
	private UUID id;

	@Column(name="Code")
	private String code;

	@Column(name="Name")
	private String name;

	@Column(name="Type")
	private Integer type;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="sole")
	private List<ProductDetail> productDetails;

	public Sole() {
	}
         @PrePersist
        @PreUpdate
        public void pre() {
            if(type==null){
                type=1;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		productDetail.setSole(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setSole(null);

		return productDetail;
	}

    @Override
    public String toString() {
       return name;
    }

        
}