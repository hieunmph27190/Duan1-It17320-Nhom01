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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the ProductDetail database table.
 *
 */
@Entity
@NamedQuery(name = "ProductDetail.findAll", query = "SELECT p FROM ProductDetail p")
public class ProductDetail implements Serializable {

    private static final long serialVersionUID = 4510968105876178687L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "genUUID")
    @GenericGenerator(name = "genUUID", strategy = "uuid2")
    private UUID id;

    @Column(name = "Amount")
    private Long amount;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "Description")
    private String description;

    private BigDecimal price;

    @Column(name = "Type")
    private Integer type;

    @Column(name = "WarrantyTime")
    private Integer warrantyTime;

    //bi-directional many-to-one association to BillDetail
    @OneToMany(mappedBy = "productDetail")
    private List<BillDetail> billDetails;

    //bi-directional many-to-one association to ExchangeDetail
    @OneToMany(mappedBy = "productDetail")
    private List<ExchangeDetail> exchangeDetails;

    //bi-directional many-to-one association to Image
    @OneToMany(mappedBy = "productDetail",cascade = javax.persistence.CascadeType.ALL)
    private List<Image> images;

    //bi-directional many-to-one association to Category
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

    //bi-directional many-to-one association to Color
    @ManyToOne
    @JoinColumn(name = "ColorId")
    private Color color;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @Cascade({CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "ProductID")
    private Product product;

    //bi-directional many-to-one association to Size
    @ManyToOne
    @JoinColumn(name = "SizeId")
    private Size size;

    //bi-directional many-to-one association to Sole
    @ManyToOne
    @JoinColumn(name = "SoleID")
    private Sole sole;

    //bi-directional many-to-one association to Trademark
    @ManyToOne
    @JoinColumn(name = "BrandId")
    private Brand brand;

    //bi-directional many-to-one association to Promotion_Product
    @OneToMany(mappedBy = "productDetail")
    private List<Promotion_Product> promotionProducts;

    public ProductDetail() {
    }

    @PrePersist
    public void prePersist() {
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

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getWarrantyTime() {
        return this.warrantyTime;
    }

    public void setWarrantyTime(Integer warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public List<BillDetail> getBillDetails() {
        return this.billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public BillDetail addBillDetail(BillDetail billDetail) {
        getBillDetails().add(billDetail);
        billDetail.setProductDetail(this);

        return billDetail;
    }

    public BillDetail removeBillDetail(BillDetail billDetail) {
        getBillDetails().remove(billDetail);
        billDetail.setProductDetail(null);

        return billDetail;
    }

    public List<ExchangeDetail> getExchangeDetails() {
        return this.exchangeDetails;
    }

    public void setExchangeDetails(List<ExchangeDetail> exchangeDetails) {
        this.exchangeDetails = exchangeDetails;
    }

    public ExchangeDetail addExchangeDetail(ExchangeDetail exchangeDetail) {
        getExchangeDetails().add(exchangeDetail);
        exchangeDetail.setProductDetail(this);

        return exchangeDetail;
    }

    public ExchangeDetail removeExchangeDetail(ExchangeDetail exchangeDetail) {
        getExchangeDetails().remove(exchangeDetail);
        exchangeDetail.setProductDetail(null);

        return exchangeDetail;
    }

    public List<Image> getImages() {
        return this.images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Image addImage(Image image) {
        getImages().add(image);
        image.setProductDetail(this);

        return image;
    }

    public Image removeImage(Image image) {
        getImages().remove(image);
        image.setProductDetail(null);

        return image;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Sole getSole() {
        return this.sole;
    }

    public void setSole(Sole sole) {
        this.sole = sole;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Promotion_Product> getPromotionProducts() {
        return this.promotionProducts;
    }

    public void setPromotionProducts(List<Promotion_Product> promotionProducts) {
        this.promotionProducts = promotionProducts;
    }

    public Promotion_Product addPromotionProduct(Promotion_Product promotionProduct) {
        getPromotionProducts().add(promotionProduct);
        promotionProduct.setProductDetail(this);

        return promotionProduct;
    }

    public Promotion_Product removePromotionProduct(Promotion_Product promotionProduct) {
        getPromotionProducts().remove(promotionProduct);
        promotionProduct.setProductDetail(null);

        return promotionProduct;
    }
    public Object[] toRow() {
        return new Object[]{this.getProduct()==null?null:this.getProduct().getProductName(),category,color,size,brand,sole,amount,price,warrantyTime,description};
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductDetail) {
            ProductDetail productDetail = (ProductDetail) obj;
            if (this.getId().toString().equals(productDetail.getId().toString())) {
                return true;
            }
        }
         return false;
    }
    

}
