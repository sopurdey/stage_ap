package fr.diginamic.stage_ap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participant {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name="CARSHARE_ID")
	private Carshare carshare;

	@Column(name = "PROFILE")
	private String profile;

	public Participant() {
		
	}
	
	public Participant(Integer id, User user, Carshare carshare, String profile) {
		super();
		this.id = id;
		this.user = user;
		this.carshare = carshare;
		this.profile = profile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Carshare getCarshare() {
		return carshare;
	}

	public void setCarshare(Carshare carshare) {
		this.carshare = carshare;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", user=" + user + ", carshare=" + carshare + ", profile=" + profile + "]";
	}

}
