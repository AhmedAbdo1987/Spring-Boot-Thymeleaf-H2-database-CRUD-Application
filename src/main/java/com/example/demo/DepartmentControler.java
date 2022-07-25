package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@Controller
public class DepartmentControler {
	@Autowired
	DepartmentService service;
	
	@GetMapping ("/")
	public String findAll(Model model) {
		model.addAttribute("departments", service.findallDepartment());
		return "all-departments";
	}
	
	/*@GetMapping ("/add")
	public String IunchAddDepartmentPage(Model model) {
		//model.addAttribute("department", new Department());
		model.addAttribute("department", new Department());
		return "add-department";
	}*/
	@GetMapping("/add")
	public String lunchAddDepartmentPage(Model model) {
		model.addAttribute("department", new Department());
		return "add-department";
	}
	@GetMapping("/edit/{id}")
	public String IunchEditPage(Model model,@PathVariable("id") int id ) {
		model.addAttribute("department", service.findDepartmentById(id));
		return "edit-department";
		
	} 
	@PostMapping("/updatedepartment")
	public String updateDepartment (Department department) {
		service.updateDepartment(department);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") int id) {
		service.deletById(id);
		return "redirect:/";
	}
	
	@PostMapping("/adddepartment")
	public String createDepartment(Department department) {
		service.addDepatment(department);
		return "redirect:/";
	}
	@GetMapping("/test")
	public String test () {
		Department st = new Department();
		st.setId(1);
		st.setName("telcom");
		st.setNoofStubent(100);
		service.addDepatment(st);
		return "redirect:/";
		
		
	}

}
