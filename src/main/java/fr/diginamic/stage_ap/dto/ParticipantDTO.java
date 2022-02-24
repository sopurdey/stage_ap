package fr.diginamic.stage_ap.dto;

import fr.diginamic.stage_ap.model.Carshare;
import fr.diginamic.stage_ap.model.User;

public class ParticipantDTO {

	private Integer id;

	private User user;

	private Carshare carshare;

	private String profile;

	public ParticipantDTO() {
		super();
	}

	public ParticipantDTO(Integer id, User user, Carshare carshare, String profile) {
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

}
