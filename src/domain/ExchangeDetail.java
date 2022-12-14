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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the ExchangeDetails database table.
 * 
 */
@Entity
@Table(name="ExchangeDetails")
@NamedQuery(name="ExchangeDetail.findAll", query="SELECT e FROM ExchangeDetail e")
public class ExchangeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	@GeneratedValue(generator = "genUUID")
	@GenericGenerator(name = "genUUID",strategy = "uuid2")
	private UUID id;

	@Column(name="Note")
	private String note;

	@Column(name="Price")
	private BigDecimal price;

	@Column(name="Quantity")
	private Integer quantity;

	@Column(name="Type")
	private Integer type;

	//bi-directional many-to-one association to Exchange
	@ManyToOne
	@JoinColumn(name="ExChangeID")
	private Exchange exchange;

	//bi-directional many-to-one association to ProductDetail
	@ManyToOne
	@JoinColumn(name="ProductDetailId")
	private ProductDetail productDetail;

	public ExchangeDetail() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Exchange getExchange() {
		return this.exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	public ProductDetail getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

}