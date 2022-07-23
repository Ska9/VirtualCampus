package com.bezkoder.spring.security.postgresql.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "cin"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 20)
	private String firstName;

	@Size(max = 20)
	private String lastName;

	@Size(max = 8)
	private String cin;

	@Size(max = 7)
	private String enrollmentNumber;

	@Size(max = 50)
	@Email
	private String email;

	@Size(max = 120)
	private String password;

	@Size(max = 8)
	private String phone;

	@Size(max = 120)
	private String street;

	@Size(max = 4)
	private String zipCode;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User(String firstName,
				String lastName,
				String cin,
				String enrollmentNumber,
				String email,
				String phone,
				String street,
				String zipCode,
				String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cin = cin;
		this.enrollmentNumber = enrollmentNumber;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.street = street;
		this.zipCode = zipCode;
	}

	public User(Long id,
				String firstName,
				String lastName,
				String cin,
				String enrollmentNumber,
				String email,
				String password,
				String phone,
				String street,
				String zipCode) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cin = cin;
		this.enrollmentNumber = enrollmentNumber;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.street = street;
		this.zipCode = zipCode;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}

	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
