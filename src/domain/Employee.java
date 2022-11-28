package domain;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the Employees database table.
 *
 */
@Entity
@Table(name = "Employees")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "genUUID")
    @GenericGenerator(name = "genUUID", strategy = "uuid2")
    private UUID id;

    @Column(name = "Password")
    private String password;

    @Column(name = "Type")
    private Integer type;

    @Column(name = "Username")
    private String username;

    //bi-directional many-to-one association to Bill
    @OneToMany(mappedBy = "employee")
    private List<Bill> bills;

    //bi-directional many-to-one association to Person
    @Column(name = "Address")
    private String address;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Column(name = "Email")
    private String email;

    @Column(name = "Gender")
    private Boolean gender;

    @Lob
    @Column(name = "Image")
    private Blob image;

    @Column(name = "LastName")
    private String name;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "BufferName")
    private String bufferName;
    //bi-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name = "RoleId")
    private Role role;

    //bi-directional many-to-one association to Exchange
    @OneToMany(mappedBy = "employee")
    private List<Exchange> exchanges;

    public Employee() {
    }

    @PrePersist
    @PreUpdate
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Bill> getBills() {
        return this.bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Bill addBill(Bill bill) {
        getBills().add(bill);
        bill.setEmployee(this);

        return bill;
    }

    public Bill removeBill(Bill bill) {
        getBills().remove(bill);
        bill.setEmployee(null);

        return bill;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBufferName() {
        return bufferName;
    }

    public String getFullName() {
        return firstName + " " + bufferName + " " + name;
    }

    public void setBufferName(String bufferName) {
        this.bufferName = bufferName;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Exchange> getExchanges() {
        return this.exchanges;
    }

    public void setExchanges(List<Exchange> exchanges) {
        this.exchanges = exchanges;
    }

    public Exchange addExchange(Exchange exchange) {
        getExchanges().add(exchange);
        exchange.setEmployee(this);

        return exchange;
    }

    public Exchange removeExchange(Exchange exchange) {
        getExchanges().remove(exchange);
        exchange.setEmployee(null);

        return exchange;
    }

    public Object[] toaddrow() {
        return new Object[]{id, firstName + bufferName + name, gender, phoneNumber, password, username, email, address, image, type};
    }

    @Override
    public String toString() {
        return name;
    }

}
