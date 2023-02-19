package net.javaguides.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.sun.istack.NotNull;



@Entity
@Table(name="user_details")
@XmlRootElement
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private int id;

	@Column(name="firstName")
	@NotNull
	private String firstName;
	@Column(name="lastName")
	@NotNull
	private String lastName;
	@Column(name="designation")
	@NotNull
	private String designation;
	@Column(name="city")
	@NotNull
	private String city;
	
	@Column(nullable = false)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@NotNull
	@CreationTimestamp
	private Date createdAt;
	
	public User() {
		
	}
	
	public User(int id, String firstName, String lastName, String designation, String city, Date updatedAt,
			Date createdAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.city = city;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	/*
	 * @Override public String toString() { return "User{"+"id="+ id
	 * +", firstName='" + firstName +'\''+ ", lastName='" + lastName + '\'' +
	 * ", desination='" + designation + '\'' + ", city=" + city + ", updateAt='" +
	 * updatedAt + ", createdAt='"+createdAt+'}';
	 * 
	 * }
	 */
	
	
}
