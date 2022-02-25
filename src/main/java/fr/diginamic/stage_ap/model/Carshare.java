package fr.diginamic.stage_ap.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Carshare {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "START_TIME")
	private Date startTime;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "ARRIVAL_TIME")
	private Date arrivalTime;

	@Column(name = "START_ADDRESS")
	private String fromAddress;

	@Column(name = "DESTINATION")
	private String toAddress;

	@Column(name = "FREE_SPACES")
	private Integer nbSpaces;

	@OneToMany(mappedBy = "carshare")
	private Set<Participant> participants;

	public Carshare() {

	}

	public Carshare(Integer id, Date startTime, Date arrivalTime, String fromAddress, String toAddress,
			Integer nbSpaces) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.arrivalTime = arrivalTime;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
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

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public Integer getNbSpace() {
		return nbSpaces;
	}

	public void setNbSpace(Integer nbSpaces) {
		this.nbSpaces = nbSpaces;
	}

	@Override
	public String toString() {
		return "Carshare [id=" + id + ", startTime=" + startTime + ", arrivalTime=" + arrivalTime + ", fromAddress="
				+ fromAddress + ", toAddress=" + toAddress + ", nbSpaces=" + nbSpaces + ", participants=" + participants
				+ "]";
	}

}
