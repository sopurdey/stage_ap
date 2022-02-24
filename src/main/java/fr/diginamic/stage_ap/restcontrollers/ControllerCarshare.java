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

import fr.diginamic.stage_ap.exceptions.CarshareNotFoundException;
import fr.diginamic.stage_ap.model.Carshare;
import fr.diginamic.stage_ap.repositories.iCrudCarshare;

@RestController
@CrossOrigin
@RequestMapping("api/carshare")
public class ControllerCarshare {
	
	@Autowired
	iCrudCarshare cc;

	public ControllerCarshare() {

	}
	
	@GetMapping("/all")
	public Iterable<Carshare> getCarshares(){
		return cc.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Carshare> getCarshare(@PathVariable("id") Integer pid) throws CarshareNotFoundException {
		if (cc.findById(pid).isEmpty()) {
			String s = "Carshare non trouvé - id : " + pid;
			throw new CarshareNotFoundException(s);
		}
		return cc.findById(pid);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCarshare(@PathVariable("id") Integer pid) throws CarshareNotFoundException {
		if (cc.findById(pid).isEmpty()) {
			String s = "Carshare non trouvé - id : " + pid;
			throw new CarshareNotFoundException(s);
		}
		cc.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Carshare supprimé !");
	}

	@PutMapping("{id}")
	public Carshare updateCarshare(@PathVariable("id") Integer pid, @Valid @RequestBody Carshare carshare, BindingResult result)
			throws CarshareNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new CarshareNotFoundException(s);
		}
		if (pid != carshare.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le carshare JSON " + carshare;
			throw new CarshareNotFoundException(s);
		}
		if (cc.findById(pid).isEmpty()) {
			String s = "Carshare non trouvé, id: " + pid;
			throw new CarshareNotFoundException(s);
		}
		return cc.save(carshare);
	}

	@PostMapping
	public Carshare addCarshare(@Valid @RequestBody Carshare carshare, BindingResult result) throws CarshareNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new CarshareNotFoundException(s);
		}
		return cc.save(carshare);
	}
}
