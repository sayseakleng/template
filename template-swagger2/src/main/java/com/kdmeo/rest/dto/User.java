package com.kdmeo.rest.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.kdmeo.rest.util.Genders;

import io.swagger.annotations.ApiModelProperty;

public class User {
	
	private int id;
	
	@ApiModelProperty(required = true)
	@NotEmpty
	private String name;
	
	@ApiModelProperty(required = true)
	@NotNull
	private Genders gender;
	
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final Genders getGender() {
		return gender;
	}
	public final void setGender(Genders gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getGender()=" + getGender() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
