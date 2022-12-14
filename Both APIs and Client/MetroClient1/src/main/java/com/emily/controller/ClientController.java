package com.emily.controller;

import java.time.LocalDate;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import com.emily.entity.Station;
import com.emily.entity.StationList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emily.entity.Customer;
import com.emily.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService service;

	// User inputs ID to login
	@RequestMapping("/")
	public ModelAndView getUserIdPage() {
		return new ModelAndView("InputCustomerId");
	}

	// Customer Account page
	@RequestMapping("/viewBalance")
	public ModelAndView accountController(@RequestParam("customerId") int id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		Customer customer = service.loginCheck(id);

		if (customer != null) {
			session.setAttribute("customer", customer);
			session.setAttribute("customerName", customer.getCustomerFirstName());
			modelAndView.setViewName("viewBalance");
			modelAndView.addObject("stationObj",new Station());
		} else {
			modelAndView.addObject("message", "No account found with that Id, Please try again");
			modelAndView.setViewName("InputUserId");
		}

		StationList stationList = service.getAllStations();
		System.out.println(stationList.toString());
		modelAndView.addObject("StationList", stationList);
		return modelAndView;
	}

	@ModelAttribute("stations")
	public Collection<Station> getStation(){
		return service.getAllStations().getStationList();
	}


	// Create a new Customer
	@RequestMapping("/addNewCustomerPage")
	public ModelAndView addPageController() {

		return new ModelAndView("InputNewCustomer", "customer", new Customer());
	}


	@RequestMapping("/addNewCustomer")
	public ModelAndView addNewCustomerController(@ModelAttribute("customer") Customer newCustomer, @RequestParam("customerDateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		ModelAndView modelAndView = new ModelAndView();
		Customer customer = new Customer();

		customer.setCustomerDateOfBirth(date);
		String message;

		if (service.addNewCustomer(customer) != null) {
			message = "New Account Created";
			modelAndView.setViewName("AccountPage");
		} else {
			message = "Unfortunately a new account was not created";
			modelAndView.setViewName("InputNewCustomer");
		}

		modelAndView.addObject("message", message);

		return modelAndView;

	}


}
