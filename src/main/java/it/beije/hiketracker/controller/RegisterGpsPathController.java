package it.beije.hiketracker.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterGpsPathController {
	@RequestMapping(value = "/registergpspath", method = RequestMethod.GET)
	public String registerGpsPath(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("account registration" + request.getContextPath());
		
		return "registergpspath";
	}
}
