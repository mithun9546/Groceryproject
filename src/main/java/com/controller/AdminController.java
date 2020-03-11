package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Product;
import com.model.User;
import com.service.ProductServices;

@Controller
public class AdminController {
	@Autowired
	JdbcTemplate jdbc;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showPage(@ModelAttribute("addproduct") Product product) {
		product= new Product();
		return "admin/addproduct";
	}
	
	  @ModelAttribute("itemList")
	   public Map<String, String> getItemList() {
	      Map<String, String> itemList = new HashMap<String, String>();
	     itemList.put("Vegetable", "Vegetable");
	     itemList.put("Fruit", "Fruit");
	     itemList.put("Home & kitchen", "Home & kitchen");
	     itemList.put("Beauty Product", "Beauty Product");
	      return itemList;
	   }
	
	 
	  @RequestMapping(value = "/admin/addproduct", method = RequestMethod.GET)
		public String addProductt(@ModelAttribute("addproduct") @Valid Product product , BindingResult result, ModelMap model) {
			 
				return "admin/addproduct";
	  }
	
	@RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("addproduct") @Valid Product product , BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "admin/addproduct";
		}
		else
		{
			ProductServices pds=new ProductServices();
			String str=pds.addProduct(product);
			jdbc.execute(str);
			model.put("msg","product added ");
			return "sucessful";
		}
	}
	
}
