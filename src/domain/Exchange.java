package domain;

import java.io.Serializable;
import java.sql.Timestamp;
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

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Exchange database table.
 * 
 */
@Entity
@NamedQuery(name="Exchange.findAll", query="SELECT e FROM Exchange e")
public class Exchange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	@GeneratedValue(generator = "genUUID")
	@GenericGenerator(name = "genUUID",strategy = "uuid2")
	private UUID id;

	@Column(name="DateTime")
	private Timestamp dateTime;

	@Column(name="Note")
	private String note;

	@Column(name="Type")
	private Integer type;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="BillId")
	private Bill bill;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EmployeeID")
	private Employee employee;

	//bi-directional many-to-one association to ExchangeDetail
	@OneToMany(mappedBy="exchange")
	private List<ExchangeDetail> exchangeDetails;

	public Exchange() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Timestamp getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<ExchangeDetail> getExchangeDetails() {
		return this.exchangeDetails;
	}

	public void setExchangeDetails(List<ExchangeDetail> exchangeDetails) {
		this.exchangeDetails = exchangeDetails;
	}

	public ExchangeDetail addExchangeDetail(ExchangeDetail exchangeDetail) {
		getExchangeDetails().add(exchangeDetail);
		exchangeDetail.setExchange(this);

		return exchangeDetail;
	}

	public ExchangeDetail removeExchangeDetail(ExchangeDetail exchangeDetail) {
		getExchangeDetails().remove(exchangeDetail);
		exchangeDetail.setExchange(null);

		return exchangeDetail;
	}

}