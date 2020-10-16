package it.beije.hiketracker.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsertGpsPathController {
	@RequestMapping(value = "/insertgpspath", method = RequestMethod.GET)
	public String insertGpsPath(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		
		
		return "insertgpspath";
	}
}
