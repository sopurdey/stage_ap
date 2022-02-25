package fr.diginamic.stage_ap.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NUMBERPLATE")
	private String numberPlate;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "SEATS")
	private Integer nbSeats;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "PHOTO")
	private String photoUrl;
	
	@OneToMany(mappedBy = "vehicle")
	private Set<Reservation> reservations;

	public Vehicle() {
		
	}
	
	public Vehicle(Integer id, String numberPlate, String brand, String model, String category, Integer nbSeats,
			String status, String photoUrl) {
		super();
		this.id = id;
		this.numberPlate = numberPlate;
		this.brand = brand;
		this.model = model;
		this.category = category;
		this.nbSeats = nbSeats;
		this.status = status;
		this.photoUrl = photoUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getNbSeats() {
		return nbSeats;
	}

	public void setNbSeats(Integer nbSeats) {
		this.nbSeats = nbSeats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", numberPlate=" + numberPlate + ", brand=" + brand + ", model=" + model
				+ ", category=" + category + ", nbSeats=" + nbSeats + ", status=" + status + ", photoUrl=" + photoUrl
				+ "]";
	}
	
}
