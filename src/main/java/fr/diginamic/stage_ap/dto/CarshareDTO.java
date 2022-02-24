package fr.diginamic.stage_ap.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CarshareDTO {

	private Integer id;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date startTime;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date arrivalTime;

	private String fromAdress;

	private String toAdress;

	private Integer nbSpaces;

	public CarshareDTO() {
		super();
	}

	public CarshareDTO(Integer id, Date startTime, Date arrivalTime, String fromAdress, String toAdress,
			Integer nbSpaces) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.arrivalTime = arrivalTime;
		this.fromAdress = fromAdress;
		this.toAdress = toAdress;
		this.nbSpaces = nbSpaces;
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

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFromAdress() {
		return fromAdress;
	}

	public void setFromAdress(String fromAdress) {
		this.fromAdress = fromAdress;
	}

	public String getToAdress() {
		return toAdress;
	}

	public void setToAdress(String toAdress) {
		this.toAdress = toAdress;
	}

	public Integer getNbSpaces() {
		return nbSpaces;
	}

	public void setNbSpaces(Integer nbSpaces) {
		this.nbSpaces = nbSpaces;
	}

}
