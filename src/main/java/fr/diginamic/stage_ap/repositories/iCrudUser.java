package fr.diginamic.stage_ap.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.diginamic.stage_ap.model.User;

public interface iCrudUser extends CrudRepository<User, Integer> {

}
