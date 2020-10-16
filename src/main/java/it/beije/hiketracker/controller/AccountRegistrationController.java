package it.beije.hiketracker.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.hiketracker.entitybeans.User;
import it.beije.hiketracker.services.UserService;

@Controller
public class AccountRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/accountregistration", method = RequestMethod.GET)
	public String accountRegistration(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("account registration" + request.getContextPath());
		
		return "accountregistration";
	}
	
	@RequestMapping(value = "/accountregistration", method = RequestMethod.POST)
	public String accountRegistration(User newUser, HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("account registration" + request.getContextPath());
		HttpSession session = request.getSession();
		String returnPath = "";
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		newUser.setFirstName(name);
		newUser.setLastName(surname);
		newUser.setEmail(email);
		newUser.setPassword(password);
		User user = userService.register(newUser); 
		if(user!=null) {
			session.setAttribute("firstName", user.getFirstName());
			session.setAttribute("lastName", user.getLastName());
			session.setAttribute("userid", user.getIdUser());
			session.setAttribute("auth", true);
			returnPath = "myaccount";
		} else {
			model.addAttribute("error", "ERROR: Email already used");
			returnPath = "accountregistration";
		} 
		
		return returnPath;
	}
}
