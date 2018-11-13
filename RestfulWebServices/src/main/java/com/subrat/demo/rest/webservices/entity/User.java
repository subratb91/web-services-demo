package com.subrat.demo.rest.webservices.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_users")
@ApiModel(description="All Details about the user.")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Size(min=2, message="Name shoud have at least 2 characters")
	@ApiModelProperty(notes="Name shoud have at least 2 characters")
	private String name;
	@Past(message="Birth Date cannot be greater than or equal to current date")
	@ApiModelProperty(notes="Birth dates should be in past")
	private Date birthDate;

	public User() {
		super();
	}

	public User(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public User(Integer id, String name, Date birthDate) {
		this(name, birthDate);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}

}
