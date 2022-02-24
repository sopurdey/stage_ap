package fr.diginamic.stage_ap.dto;

import fr.diginamic.stage_ap.model.Role;

public class RoleDTO {

	private Integer id;

	private String label;

	public RoleDTO() {
		// TODO Auto-generated constructor stub
	}

	public RoleDTO( String label) {
		super();
		this.label = label;
	}
	
	public RoleDTO(Role role) {
		this.id = role.getId();
		this.label = role.getLabel();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
