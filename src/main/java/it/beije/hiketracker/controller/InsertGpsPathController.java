package it.beije.hiketracker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.hiketracker.entitybeans.Route;
import it.beije.hiketracker.services.RouteService;

@Controller
public class InsertGpsPathController {
	@Autowired
	private RouteService routeService;

	@RequestMapping(value = "/insertgpspath", method = RequestMethod.GET)
	public String insertGpsPath() {
		
		
		return "insertgpspath";
	}
	
	@RequestMapping(value = "/insertgpspath", method = RequestMethod.POST)
	public String insertGpsPath(HttpServletRequest request, Model model) {
		
		Route temp = new Route();
		HttpSession session = request.getSession();
		temp.setStart(request.getParameter("start"));
		temp.setStartDateTime(request.getParameter("startDateTime"));
		temp.setFinish(request.getParameter("finish"));
		temp.setFinishDateTime(request.getParameter("finishDateTime"));
		temp.setFullRoute(request.getParameter("fullRoute"));
		routeService.insert((Integer)session.getAttribute("userid"),
				Integer.parseInt(request.getParameter("transport")), 
				temp);
		model.addAttribute("route", temp.getFullRoute());
		
		return "insertgpspath";
	}
}
