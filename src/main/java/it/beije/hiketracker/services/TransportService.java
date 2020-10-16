package it.beije.hiketracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hiketracker.repositories.TransportRepository;

@Service
public class TransportService {

	@Autowired
	private TransportRepository transportRepository;
}
