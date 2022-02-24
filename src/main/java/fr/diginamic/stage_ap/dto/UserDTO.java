package fr.diginamic.stage_ap.dto;

import java.util.HashSet;
import java.util.Set;

import fr.diginamic.stage_ap.model.Participant;
import fr.diginamic.stage_ap.model.User;

public class UserDTO {

	private Integer id;

	private String username;

	private String password;

	private String lastName;

	private String firstName;

	private String email;

	private String phone;

	private Set<ParticipantDTO> participants;

	private RoleDTO role;

	public UserDTO() {
		super();
	}

	public UserDTO(Integer id, String username, String password, String lastName, String firstName, String email,
			String phone, Set<ParticipantDTO> participants, RoleDTO role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.participants = participants;
		this.role = role;
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.lastName = user.getLastName();
		this.firstName = user.getFirstName();
		this.email = user.getEmail();
		this.phone = user.getPassword();
		if (user.getRole() != null) {
			this.role = new RoleDTO(user.getRole());
		}
		this.participants = new HashSet<ParticipantDTO>();
		for (Participant particip : user.getParticipants()) {
			ParticipantDTO participantDTO = new ParticipantDTO(particip.getId(), particip.getUser(),
					particip.getCarshare(), particip.getProfile());
			this.participants.add(participantDTO);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<ParticipantDTO> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<ParticipantDTO> participants) {
		this.participants = participants;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

}
