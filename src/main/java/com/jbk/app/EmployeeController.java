package com.jbk.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Employee;

@RestController//methods in this class returning data in json or xml
//@Controller-this behaves like normal mvc controller
public class EmployeeController {

	@Autowired
	private EmployeeRepo r;


	@GetMapping(path = "/employees",produces= {"application/xml"})
	//@ResponseBody-required for normal controller
	public List<Employee> getEmployees() {
		List<Employee> l = r.findAll();
		System.out.println("Changes Done in Employee Controller...........");
		return l;
	}
	
	@GetMapping("employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee e = r.findById(id).orElse(new Employee(0, ""));
		return e;
	}
	
	@PostMapping(path = "addemployee",consumes = {"application/json"})
	public Employee addEmployee(@RequestBody Employee e) {//@requestbody converts json data into java object
		r.save(e);
		return e;
	}
	

}
