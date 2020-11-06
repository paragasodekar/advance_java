package com.cdac.cntr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.cdac.dto.User;
import com.cdac.dto.Shipment;
import com.cdac.service.UserService;
import com.cdac.valid.RegValidator;
import com.cdac.valid.UserValidator;
import com.cdac.valid.forgotValidator;
import com.cdac.valid.forgotValidator2;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private RegValidator regValidator;
	
	@Autowired
	private forgotValidator forValidator;
	@Autowired
	private forgotValidator2 forValidator2;
	
	@RequestMapping(value = "/prep_reg_form.htm",method = RequestMethod.GET)
	public String prepRegForm(ModelMap map) {
		map.put("user", new User());
		return "reg_form";
	}
	
	@RequestMapping(value = "/reg.htm",method = RequestMethod.POST)
	public String register(@ModelAttribute User user,BindingResult result,ModelMap map) {
		regValidator.validate(user, result);
		if(result.hasErrors()) {
			map.put("user", user);
			return "reg_form";
		}
		
		userService.addUser(user);
		return "index";
	}
	
	@RequestMapping(value = "/prep_log_form.htm",method = RequestMethod.GET)
	public String prepLogForm(ModelMap map) {
		map.put("user", new User());
		return "login_form";
	}
	
	@RequestMapping(value = "/login.htm",method = RequestMethod.POST)
	public String login(@ModelAttribute User user,BindingResult result,ModelMap map,HttpSession session,SessionStatus status , HttpServletRequest httpServletRequest) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "login_form";
		}
		
		boolean b = userService.findUser(user);
		if(b) {
			session.setAttribute("user", user);
			session.setAttribute("boolean", true);
			map.put("shipment", new Shipment());
			return "redirect:home_page.htm";
		}else {
			map.put("user", new User());
			return "login_form";
		} 
	}
	
	@RequestMapping(value = "/home_page.htm",method = RequestMethod.GET)
	public String homepage(ModelMap map, Shipment shipment, User user,HttpSession session,SessionStatus status , HttpServletRequest httpServletRequest) {
		if(!routeprotect(session)) {
			return "redirect:prep_log_form.htm";
		}
	map.put("shipment", shipment);
	map.put("user", user);
	return "home";	
	}
	
	public static boolean routeprotect(HttpSession session) {
		boolean b=(boolean) session.getAttribute("boolean");
		if(!b) {
			return false;
		}
		return true;
	}
	
	@RequestMapping(value = "/logout.htm",method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("boolean", false);		 
		return "redirect:prep_log_form.htm";
	}
	
	@RequestMapping(value = "/prep_forget_pass1.htm",method = RequestMethod.GET)
	public String forget_pass_Form1(ModelMap map) {
		map.put("user", new User());
		return "forget_pass1";
	}
	
	@RequestMapping(value = "/forget_pass_email.htm",method = RequestMethod.POST)
	public String forgetpass1(@ModelAttribute User user,BindingResult result,ModelMap map,HttpSession session,SessionStatus status) {
		forValidator.validate(user, result);
		if(result.hasErrors()) {
			return "forget_pass1";
		}
		boolean b = userService.verifymail(user);
		if(b) {
			map.put("user", user);
			return "forget_pass2";			
		}else {
			map.put("user", new User());
			return "forget_pass1";			
		} 
	}
	
	@RequestMapping(value = "/prep_forget_pass2.htm",method = RequestMethod.GET)
	public String forget_pass_Form2(ModelMap map,@ModelAttribute User user) {
		map.put("user", user);
		return "forget_pass2";
	}
	
	
	@RequestMapping(value = "/forget_pass_pass.htm",method = RequestMethod.POST)
	public String forgetpass2(@ModelAttribute User user,BindingResult result,ModelMap map,HttpSession session,SessionStatus status) {
		forValidator2.validate(user, result);
		if(result.hasErrors()) {
			return "forget_pass2";
		}
		else {
		userService.setpass(user);
		return "redirect:prep_log_form.htm";}
		
}
}
