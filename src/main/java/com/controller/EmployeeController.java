package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Employee;
import com.service.IEmployeeSvc;
import com.validator.CustomEmployeeValidator;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	IEmployeeSvc employeeSvc;
	@Autowired
	CustomEmployeeValidator customEmployeeValidator; 

	@RequestMapping(value = "/create.htm", method = RequestMethod.GET)
	public String register(ModelMap model) {
		model.addAttribute("employee", new Employee());
		return "employee/employeeRegister";
	}

	@RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String registerSubmit(@Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "employee/employeeRegister";
		} else {
			employeeSvc.save(employee);
			return "redirect:/employee/list.htm";
		}
 

	}
	
	@RequestMapping(value = "/edit/{id}.htm", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id,ModelMap map) {
		Employee employee = employeeSvc.findById(id);
		map.put("employee", employee);
		System.out.println(employee);
		return "employee/employeeEdit";
	}
	
	@RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
	public String editSubmit(@Valid Employee employee,BindingResult result) {
		if (result.hasErrors()) {
			return "employee/employeeRegister";
		} else {
			employeeSvc.update(employee);
			return "redirect:/employee/list.htm";
		}
 

	}

	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Employee> employees = employeeSvc.findAll();
		map.put("employeelist", employees);
		return "employee/employeeList";
	}
	@RequestMapping(value = "/delete/{id}.htm", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id,ModelMap map) {
		employeeSvc.delete(id);
		return "redirect:/employee/list.htm";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	dateFormat.setLenient(false);
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//	webDataBinder.addValidator(customEmployeeValidator);
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
 
		ModelAndView model = new ModelAndView("employee/errorPage");
		model.addObject("exception", ex);
		return model;
 
	}
 


}
