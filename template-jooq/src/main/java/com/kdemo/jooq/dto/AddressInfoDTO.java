package com.kdemo.jooq.dto;

public class AddressInfoDTO {

    private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "AddressInfoDTO [gender=" + gender + "]";
	}
}
