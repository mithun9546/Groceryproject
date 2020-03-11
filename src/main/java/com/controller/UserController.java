package com.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import org.onlineshoppingportal.exceptions.ProductOutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.service.ProductOrder;
import com.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Login;
import com.model.Product;
import com.model.User;
import com.model.AdminLogin;;

@Controller
public class UserController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	private ProductOrder productOrder;


	@ModelAttribute("radio")
	public List<String> radioOptions() {
		List<String> radio = new ArrayList();
		radio.add("Male");
		radio.add("Female");
		return radio;
	}
	@RequestMapping(value = "/fetch")
	public ModelAndView listProduct(ModelAndView model) throws IOException {

		List<Product> listProduct = productOrder.prodList();
		model.addObject("listProduct", listProduct);
		model.setViewName("productshow");
		System.out.println("hii");

		return model;
	}
	
	
/*	@RequestMapping(value="/buyProduct")
	//@ResponseBody
	public String buyProduct(Model model, @RequestParam(value = "ItemId", defaultValue = "") String ItemId){
		if(ItemId.isEmpty())
    	{
    		return "redirect:/productList";
    	}
		 Product product = null;
		 if (ItemId != null && ItemId.length() > 0) {
	            //product = product.getItemId(ItemId);
	        }
		else
			return "sucessful";
	}*/
	
	 /*@RequestMapping({ "/buyProduct" })
	    public String buyProduct(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
	    	if(code.isEmpty())
	    	{
	    		return "redirect:/productList";
	    	}
	    	
	        Product product = null;
	        if (code != null && code.length() > 0) {
	            product = productDAO.findProduct(code);
	        }
	        if (product != null) {
	        	if(product.getQuantity() == 0)
	        	{	
					logger.error("Product out of stock having code "+code);
	        		throw new ProductOutOfStockException();
	        	}
	        	model.addAttribute("product",product);
	        }
	    	else
	        return "confirmation";
	    }*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showPagee() {
		
		return "sucessful";
	}
	*/
	
	/*@PostMapping("/")
	public String checkPersonInfo(@Valid Ticket ticket, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "showpage";
		}

		return "redirect:/sucessful";
	}*/
	
	
	
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showPage() {
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/userdata", method = RequestMethod.GET)
	public String showPage(@ModelAttribute("user") User user) {
		user = new User();
		return "showpage";
	}

	@RequestMapping(value = "/userdata", method = RequestMethod.POST)
	public String calculateTotalCost(@ModelAttribute("user") @Valid User user , BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "showpage";
		}
		if (!user.getCpassword().equals(user.getPassword())) {
			model.put("passerror", "password do not match!");
			return "showpage";
		} 
		else {
			TicketService tk = new TicketService();
			String error = tk.check(user);
			List result1 = jdbc.queryForList(error);
			// System.out.println("result " + result1);
			if (!result1.isEmpty()) {
				model.put("Error", "User Already Exist!!!");
				return "showpage";

			} else {
				String str = tk.insert(user);
				jdbc.execute(str);

				return "Mainpage";
			}

		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(@ModelAttribute("login") Login login) {
		return "login";
	}

	@RequestMapping(value = "/loginentry", method = RequestMethod.POST)
	public String LoginPost(@ModelAttribute("login") Login login, BindingResult result, ModelMap model) {
		if (login.getLemail().isEmpty()) {
			model.put("userId", "User Id is mandatory");
		}
		if (login.getLpassword().isEmpty()) {
			model.put("password", "Password is mandatory");
		}
		TicketService tk = new TicketService();
		String str = tk.loginCheck(login);
		List result1 = jdbc.queryForList(str);
		//System.out.println("result1" + result1);
		if (result1.isEmpty()) {
			model.put("error", "Wrong Credential!!");
			return "login";
		} else {
			model.put("msg", "User");
			return "sucessful";
		}

	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String AdminLogin(@ModelAttribute("adminlogin") AdminLogin adminlogin) {

		return "AdminLogin";
	}

	@RequestMapping(value = "/adminloginentry", method = RequestMethod.POST)
	public String LoginPost(@ModelAttribute("adminlogin") AdminLogin adminlogin, ModelMap model, BindingResult result) {
		TicketService tk = new TicketService();
		String str = tk.AdminLoginCheck(adminlogin);
		List result1 = jdbc.queryForList(str);
		// System.out.println("result1" + result1);
		if (adminlogin.getUsername().isEmpty()) {
			model.put("user", "Enter the user id");

		}
		if (adminlogin.getPassword().isEmpty()) {
			model.put("pass", "Enter the Password");
		}
		if (result1.isEmpty()) {
			model.put("error", "Admin Not Exist");
			return "AdminLogin";
		} else {
			model.put("msg", "Admin");
			//return "sucessful";
			return "admin/admindashbord";
		}

	}

	/*
	 * @RequestMapping("/insert") public String index(){
	 * jdbc.execute("insert into user(name,email)values('siqique','kjjkk')");
	 * return "data inserted Successfully"; }
	 * 
	 * @RequestMapping("/update") public List display(){ //ResultSet
	 * rs=stmt.executeQuery("select * from emp"); String query =
	 * "SELECT * FROM user"; System.out.println("hbjygf"+jdbc); List results =
	 * jdbc.queryForList(query); System.out.println(results); return results;
	 */

}
