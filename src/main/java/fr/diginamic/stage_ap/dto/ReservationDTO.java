package fr.diginamic.stage_ap.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationDTO {

	private Integer id;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date startTime;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date endTime;
	
	private boolean withDriver;

	private UserDTO user;
	
	private VehicleDTO vehicle;

	public ReservationDTO() {
		super();
	}

	public ReservationDTO(Integer id, Date startTime, Date endTime, boolean withDriver, UserDTO user,
			VehicleDTO vehicle) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.withDriver = withDriver;
		this.user = user;
		this.vehicle = vehicle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isWithDriver() {
		return withDriver;
	}

	public void setWithDriver(boolean withDriver) {
		this.withDriver = withDriver;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}
	
}
