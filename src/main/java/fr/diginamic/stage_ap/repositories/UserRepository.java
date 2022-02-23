package fr.diginamic.stage_ap.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.diginamic.stage_ap.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.username = :username")
	Optional<User> findUserWithName(String username);

}
