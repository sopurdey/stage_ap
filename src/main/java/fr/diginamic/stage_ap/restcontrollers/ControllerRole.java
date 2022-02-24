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

import fr.diginamic.stage_ap.exceptions.RoleNotFoundException;
import fr.diginamic.stage_ap.model.Role;
import fr.diginamic.stage_ap.repositories.iCrudRole;

@RestController
@CrossOrigin
@RequestMapping("api/role")
public class ControllerRole {
	
	@Autowired
	iCrudRole cr;

	public ControllerRole() {

	}
	
	@GetMapping("/all")
	public Iterable<Role> getRoles(){
		return cr.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Role> getRole(@PathVariable("id") Integer pid) throws RoleNotFoundException {
		if (cr.findById(pid).isEmpty()) {
			String s = "Role non trouvé - id : " + pid;
			throw new RoleNotFoundException(s);
		}
		return cr.findById(pid);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRole(@PathVariable("id") Integer pid) throws RoleNotFoundException {
		if (cr.findById(pid).isEmpty()) {
			String s = "Role non trouvé - id : " + pid;
			throw new RoleNotFoundException(s);
		}
		cr.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Role supprimé !");
	}

	@PutMapping("{id}")
	public Role updateRole(@PathVariable("id") Integer pid, @Valid @RequestBody Role role, BindingResult result)
			throws RoleNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new RoleNotFoundException(s);
		}
		if (pid != role.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le role JSON " + role;
			throw new RoleNotFoundException(s);
		}
		if (cr.findById(pid).isEmpty()) {
			String s = "Role non trouvé, id: " + pid;
			throw new RoleNotFoundException(s);
		}
		return cr.save(role);
	}

	@PostMapping
	public Role addRole(@Valid @RequestBody Role role, BindingResult result) throws RoleNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new RoleNotFoundException(s);
		}
		return cr.save(role);
	}
}
