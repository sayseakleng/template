package com.kdemo.jooq.dto;

import java.util.List;

public class UserDTO {
	
	private Long   id;
	
    private String name;
    
    private List<AddressInfoDTO> infos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AddressInfoDTO> getInfos() {
		return infos;
	}

	public void setInfos(List<AddressInfoDTO> infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", infos=" + infos + "]";
	}
}
