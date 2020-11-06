package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cdac.dto.User;
import com.cdac.dto.*;
import com.cdac.service.ShipmentService;

@Controller
@SessionAttributes("user")
public class ShipmentController {
	
	@Autowired
	private ShipmentService shipmentService;
	
	
	@RequestMapping(value = "/get_quote.htm",method = RequestMethod.POST)
	public String expenseAdd(Shipment shipment,HttpSession session,ModelMap map) {
		if(!UserController.routeprotect(session)) {
			return "redirect:prep_log_form.htm";
		}
		int userId = ((User)session.getAttribute("user")).getUserId();
		shipment.setUserId(userId); 
		shipmentService.selectFare(shipment);
		session.setAttribute("shipment", shipment);
		map.put("shipment", shipment);
		return "show_quote";
	}
	
	@RequestMapping(value = "/prep_book_form.htm",method = RequestMethod.GET)
	public String book_Form(Shipment shipment,ModelMap map,HttpSession session) {
		if(!UserController.routeprotect(session)) {
			return "redirect:prep_log_form.htm";
		}
		map.put("shipment", shipment);
		return "book_form";
	}
	
	
	@RequestMapping(value = "/confirm_book.htm",method = RequestMethod.POST)
	public String confirmbook(Shipment shipment,ModelMap map,HttpSession session) {
		if(!UserController.routeprotect(session)) {
			return "redirect:prep_log_form.htm";
		}
		int userId = ((User)session.getAttribute("user")).getUserId();
		shipment.setUserId(userId);
		shipment.setFromCity(((Shipment)session.getAttribute("shipment")).getFromCity());
		shipment.setToCity(((Shipment)session.getAttribute("shipment")).getToCity());
		shipment.setShipmentSize(((Shipment)session.getAttribute("shipment")).getShipmentSize());
		shipment.setTotalCharges(((Shipment)session.getAttribute("shipment")).getTotalCharges());
		shipmentService.addShipment(shipment);
		return "home";
	}
	
	@RequestMapping(value = "/cart_form.htm",method = RequestMethod.GET)
	public String cart_Form(Shipment shipment,ModelMap map,HttpSession session) {
		if(!UserController.routeprotect(session)) {
			return "redirect:prep_log_form.htm";
		}
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Shipment> li = shipmentService.selectAll(userId);
		map.put("shipList", li);
		map.put("uid", userId);
		return "shipment_list";
	}
	
	
	@RequestMapping(value = "/shipment_delete.htm",method = RequestMethod.GET)
	public String expenseDelete(@RequestParam int shipmentId,@RequestParam int userId,ModelMap map,HttpSession session, Shipment shipment) {
		if(!UserController.routeprotect(session)) {
			return "redirect:prep_log_form.htm";
		}
		
		shipmentService.removeShipment(shipmentId); 
		
		List<Shipment> le = shipmentService.selectAll(userId);
		map.put("shiplist", le);
		map.put("uid", userId);
//		map.put("shipment",new Shipment());
		return "redirect:cart_form.htm";
	}
	
	@RequestMapping(value = "/shipment_update_form.htm",method = RequestMethod.GET)
	public String expenseUpdateForm(@RequestParam int shipmentId,ModelMap map,HttpSession session) {
		if(!UserController.routeprotect(session)) {
			return "redirect:prep_log_form.htm";
		}
		Shipment exp = shipmentService.findShipment(shipmentId);
		map.put("shipment", exp);
		
		return "shipment_update_form";
	}
	
	
	@RequestMapping(value = "/shipment_update.htm",method = RequestMethod.POST)
	public String expenseUpdate(Shipment shipment,ModelMap map,HttpSession session) {
		if(!UserController.routeprotect(session)) {
			return "redirect:prep_log_form.htm";
		}
		int userId = ((User)session.getAttribute("user")).getUserId();
		shipment.setUserId(userId);
		shipmentService.modifyShipment(shipment);
			
		List<Shipment> li = shipmentService.selectAll(userId);
		return "redirect:cart_form.htm";
	}
	
}
