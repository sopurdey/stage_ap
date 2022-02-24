package fr.diginamic.stage_ap.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.diginamic.stage_ap.exceptions.CarshareNotFoundException;
import fr.diginamic.stage_ap.exceptions.ParticipantNotFoundException;
import fr.diginamic.stage_ap.exceptions.RoleNotFoundException;
import fr.diginamic.stage_ap.exceptions.UserNotFoundException;
import fr.diginamic.stage_ap.exceptions.VehicleNotFoundException;

@RestControllerAdvice
public class ControllerGeneralError {
	
	@ExceptionHandler(value = { CarshareNotFoundException.class })
	public ResponseEntity<String> onErrorCarshare(CarshareNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CarshareError : " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { ParticipantNotFoundException.class })
	public ResponseEntity<String> onErrorParticipant(ParticipantNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ParticipantError: " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { RoleNotFoundException.class })
	public ResponseEntity<String> onErrorClient(RoleNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RoleError: " + ex.getMessage());
	}

	@ExceptionHandler(value = { UserNotFoundException.class })
	public ResponseEntity<String> onErrorCompte(UserNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserError: " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { VehicleNotFoundException.class })
	public ResponseEntity<String> onErrorLivretA(VehicleNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VehicleError: " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<String> onError(Exception ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("OtherError: " + ex.getMessage());
	}

}
