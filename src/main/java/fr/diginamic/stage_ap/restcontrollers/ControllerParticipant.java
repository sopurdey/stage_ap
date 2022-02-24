package fr.diginamic.stage_ap.restcontrollers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.stage_ap.exceptions.ParticipantNotFoundException;
import fr.diginamic.stage_ap.model.Participant;
import fr.diginamic.stage_ap.repositories.iCrudParticipant;

@RestController
@CrossOrigin
@RequestMapping("api/participant")
public class ControllerParticipant {
	
	@Autowired
	iCrudParticipant cp;

	public ControllerParticipant() {

	}
	
	@GetMapping("/all")
	public Iterable<Participant> getParticipants(){
		return cp.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Participant> getParticipant(@PathVariable("id") Integer pid) throws ParticipantNotFoundException {
		if (cp.findById(pid).isEmpty()) {
			String s = "Participant non trouvé - id : " + pid;
			throw new ParticipantNotFoundException(s);
		}
		return cp.findById(pid);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteParticipant(@PathVariable("id") Integer pid) throws ParticipantNotFoundException {
		if (cp.findById(pid).isEmpty()) {
			String s = "Participant non trouvé - id : " + pid;
			throw new ParticipantNotFoundException(s);
		}
		cp.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Participant supprimé !");
	}

	@PutMapping("{id}")
	public Participant updateParticipant(@PathVariable("id") Integer pid, @Valid @RequestBody Participant participant, BindingResult result)
			throws ParticipantNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new ParticipantNotFoundException(s);
		}
		if (pid != participant.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le participant JSON " + participant;
			throw new ParticipantNotFoundException(s);
		}
		if (cp.findById(pid).isEmpty()) {
			String s = "Participant non trouvé, id: " + pid;
			throw new ParticipantNotFoundException(s);
		}
		return cp.save(participant);
	}

	@PostMapping
	public Participant addParticipant(@Valid @RequestBody Participant participant, BindingResult result) throws ParticipantNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new ParticipantNotFoundException(s);
		}
		return cp.save(participant);
	}
}
