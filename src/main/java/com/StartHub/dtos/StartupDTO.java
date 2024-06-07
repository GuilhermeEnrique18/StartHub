package com.StartHub.dtos;

import com.StartHub.model.Startup;

public class StartupDTO {

    private Long id;
	private String name;
	private String description;
	
	public StartupDTO(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public StartupDTO() {
		super();
	}
	
	public StartupDTO(Startup entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
