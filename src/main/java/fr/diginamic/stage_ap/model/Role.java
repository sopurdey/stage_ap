package fr.diginamic.stage_ap.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Role {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@NotNull
	@Column(name="LABEL")
	private String label;
	
	@OneToMany(mappedBy="role")
	private Set<User> users;

	public Role() {

	}

	public Role(Integer id, @NotNull String label) {
		super();
		this.id = id;
		this.label = label;
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

	@Override
	public String toString() {
		return "Role [id=" + id + ", label=" + label + "]";
	}

}
