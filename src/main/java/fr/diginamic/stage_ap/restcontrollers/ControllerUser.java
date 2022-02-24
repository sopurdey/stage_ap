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

import fr.diginamic.stage_ap.exceptions.UserNotFoundException;
import fr.diginamic.stage_ap.model.User;
import fr.diginamic.stage_ap.repositories.iCrudUser;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class ControllerUser {
	
	@Autowired
	iCrudUser cu;

	public ControllerUser() {

	}
	
	@GetMapping("/all")
	public Iterable<User> getUsers(){
		return cu.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<User> getUser(@PathVariable("id") Integer pid) throws UserNotFoundException {
		if (cu.findById(pid).isEmpty()) {
			String s = "User non trouvé - id : " + pid;
			throw new UserNotFoundException(s);
		}
		return cu.findById(pid);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer pid) throws UserNotFoundException {
		if (cu.findById(pid).isEmpty()) {
			String s = "User non trouvé - id : " + pid;
			throw new UserNotFoundException(s);
		}
		cu.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("User supprimé !");
	}

	@PutMapping("{id}")
	public User updateUser(@PathVariable("id") Integer pid, @Valid @RequestBody User user, BindingResult result)
			throws UserNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new UserNotFoundException(s);
		}
		if (pid != user.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le user JSON " + user;
			throw new UserNotFoundException(s);
		}
		if (cu.findById(pid).isEmpty()) {
			String s = "User non trouvé, id: " + pid;
			throw new UserNotFoundException(s);
		}
		return cu.save(user);
	}

	@PostMapping
	public User addUser(@Valid @RequestBody User user, BindingResult result) throws UserNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new UserNotFoundException(s);
		}
		return cu.save(user);
	}
}
