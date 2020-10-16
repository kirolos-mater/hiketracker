package it.beije.hiketracker.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyAccountController {
	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public String myAccount(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("account registration" + request.getContextPath());
		
		return "myaccount";
	}
}
