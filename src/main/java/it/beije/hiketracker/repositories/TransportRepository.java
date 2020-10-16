package it.beije.hiketracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.hiketracker.entitybeans.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer>{

}
