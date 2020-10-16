package it.beije.hiketracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.hiketracker.entitybeans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}