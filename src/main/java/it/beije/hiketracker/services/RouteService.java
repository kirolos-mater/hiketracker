package it.beije.hiketracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hiketracker.repositories.RouteRepository;

@Service
public class RouteService {
	
	@Autowired
	private RouteRepository routeRepository;

}
