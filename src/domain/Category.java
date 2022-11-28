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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Categories database table.
 * 
 */
@Entity
@Table(name="Categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	@GeneratedValue(generator = "genUUID")
	@GenericGenerator(name = "genUUID",strategy = "uuid2")
	private UUID id;

	@Column(name="CategoryName")
	private String name;

	@Column(name="Code")
	private String code;

	@Column(name="Type")
	private Integer type;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="category")
	private List<ProductDetail> productDetails;

	public Category() {
	}
         @PrePersist
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

	public String getCategoryName() {
		return this.name;
	}

	public void setCategoryName(String categoryName) {
		this.name = categoryName;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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
		productDetail.setCategory(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setCategory(null);

		return productDetail;
	}

    @Override
    public String toString() {
       return name;
    }

        
}