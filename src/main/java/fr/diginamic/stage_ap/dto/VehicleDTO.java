package fr.diginamic.stage_ap.dto;

public class VehicleDTO {

	private Integer id;

	private String numberPlate;

	private String brand;

	private String model;

	private String category;

	private Integer nbSeats;

	private String status;

	private String photoUrl;

	private boolean withDriver;

	public VehicleDTO() {
		super();
	}

	public VehicleDTO(Integer id, String numberPlate, String brand, String model, String category, Integer nbSeats,
			String status, String photoUrl, boolean withDriver) {
		super();
		this.id = id;
		this.numberPlate = numberPlate;
		this.brand = brand;
		this.model = model;
		this.category = category;
		this.nbSeats = nbSeats;
		this.status = status;
		this.photoUrl = photoUrl;
		this.withDriver = withDriver;
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

	public boolean isWithDriver() {
		return withDriver;
	}

	public void setWithDriver(boolean withDriver) {
		this.withDriver = withDriver;
	}
	
}
