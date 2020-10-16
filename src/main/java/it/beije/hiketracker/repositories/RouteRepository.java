package it.beije.hiketracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.hiketracker.entitybeans.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{

}
