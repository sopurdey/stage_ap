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

import fr.diginamic.stage_ap.exceptions.VehicleNotFoundException;
import fr.diginamic.stage_ap.model.Vehicle;
import fr.diginamic.stage_ap.repositories.iCrudVehicle;

@RestController
@CrossOrigin
@RequestMapping("api/vehicle")
public class ControllerVehicle {
	
	@Autowired
	iCrudVehicle cv;

	public ControllerVehicle() {

	}
	
	@GetMapping("/all")
	public Iterable<Vehicle> getVehicles(){
		return cv.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Vehicle> getVehicle(@PathVariable("id") Integer pid) throws VehicleNotFoundException {
		if (cv.findById(pid).isEmpty()) {
			String s = "Vehicle non trouvé - id : " + pid;
			throw new VehicleNotFoundException(s);
		}
		return cv.findById(pid);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") Integer pid) throws VehicleNotFoundException {
		if (cv.findById(pid).isEmpty()) {
			String s = "Vehicle non trouvé - id : " + pid;
			throw new VehicleNotFoundException(s);
		}
		cv.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Vehicle supprimé !");
	}

	@PutMapping("{id}")
	public Vehicle updateVehicle(@PathVariable("id") Integer pid, @Valid @RequestBody Vehicle vehicle, BindingResult result)
			throws VehicleNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new VehicleNotFoundException(s);
		}
		if (pid != vehicle.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le vehicle JSON " + vehicle;
			throw new VehicleNotFoundException(s);
		}
		if (cv.findById(pid).isEmpty()) {
			String s = "Vehicle non trouvé, id: " + pid;
			throw new VehicleNotFoundException(s);
		}
		return cv.save(vehicle);
	}

	@PostMapping
	public Vehicle addVehicle(@Valid @RequestBody Vehicle vehicle, BindingResult result) throws VehicleNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new VehicleNotFoundException(s);
		}
		return cv.save(vehicle);
	}
}
