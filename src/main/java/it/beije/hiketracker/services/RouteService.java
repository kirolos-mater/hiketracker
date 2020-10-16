package it.beije.hiketracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.hiketracker.entitybeans.Route;
import it.beije.hiketracker.entitybeans.Transport;
import it.beije.hiketracker.entitybeans.User;
import it.beije.hiketracker.repositories.RouteRepository;
import it.beije.hiketracker.repositories.TransportRepository;
import it.beije.hiketracker.repositories.UserRepository;

@Service
public class RouteService {
	
	@Autowired
	private RouteRepository routeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TransportRepository transportRepository;
	
	@Transactional
	public void insert(Integer userId, Integer transportId, Route route) {
		
		User u = userRepository.getOne(userId);
		Transport t = transportRepository.getOne(transportId);
		route.setUser(u);
		route.setTransport(t);
		routeRepository.save(route);
		
	}

}
