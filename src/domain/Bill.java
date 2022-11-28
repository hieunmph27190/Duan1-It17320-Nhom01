package domain;

import java.io.Serializable;
import java.sql.Timestamp;
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

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Bill database table.
 * 
 */
@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	@GeneratedValue(generator = "genUUID")
	@GenericGenerator(name = "genUUID",strategy = "uuid2")
	private UUID id;

	@Column(name="CreateDate")
	private Date createDate;

	@Column(name="Type")
	private Integer type;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CustomerId")
	private Customer customer;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EmployeeId")
	private Employee employee;

	//bi-directional many-to-one association to BillDetail
	@OneToMany(mappedBy="bill")
	private List<BillDetail> billDetails;

	//bi-directional many-to-one association to Exchange
	@OneToMany(mappedBy="bill")
	private List<Exchange> exchanges;

	public Bill() {
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

	public Date getCreateDate() {
		return this.createDate;
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

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<BillDetail> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public BillDetail addBillDetail(BillDetail billDetail) {
		getBillDetails().add(billDetail);
		billDetail.setBill(this);

		return billDetail;
	}

	public BillDetail removeBillDetail(BillDetail billDetail) {
		getBillDetails().remove(billDetail);
		billDetail.setBill(null);

		return billDetail;
	}

	public List<Exchange> getExchanges() {
		return this.exchanges;
	}

	public void setExchanges(List<Exchange> exchanges) {
		this.exchanges = exchanges;
	}

	public Exchange addExchange(Exchange exchange) {
		getExchanges().add(exchange);
		exchange.setBill(this);

		return exchange;
	}

	public Exchange removeExchange(Exchange exchange) {
		getExchanges().remove(exchange);
		exchange.setBill(null);

		return exchange;
	}

}