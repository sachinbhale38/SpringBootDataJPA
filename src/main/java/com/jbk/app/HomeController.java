package com.jbk.app;

import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.model.Employee;



@Controller
public class HomeController {
	
	@Autowired
	private EmployeeRepo r;
	

	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "employees");
	System.out.println("Changes done in home controller................");	
	}
	
	@RequestMapping("/index")
	public String home() {
		return "index";

	}
	@RequestMapping("/")
	public String addEmployee() {
		return "employee";

	}
	/*
	 * //using servlet
	 * 
	 * @RequestMapping("add") public String add(HttpServletRequest req ) { int
	 * i=Integer.parseInt(req.getParameter("num1")); int
	 * j=Integer.parseInt(req.getParameter("num2"));
	 * 
	 * int sum=i+j;
	 * 
	 * HttpSession ssn=req.getSession(); ssn.setAttribute("sum", sum); return
	 * "result.jsp"; }
	
	*****requestparam comes from url
	@RequestMapping("add") 
	public String add(@RequestParam("num1")int i,@RequestParam("num2") int j,HttpSession ssn) {
		
		int sum=i+j;
		ssn.setAttribute("sum", sum);
		
		return "result.jsp" ;	
	}
	*/
	
	@RequestMapping("add") 
	public ModelAndView add(@RequestParam("num1")int i,@RequestParam("num2") int j) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result");
		int sum=i+j;
		mv.addObject("sum", sum);
		return mv;
		
	}

	/*
	@RequestMapping("/addEmployee")
	public String addEmployees(@RequestParam("id")int id,@RequestParam("name") String name,Model m) {
		Employee e=new Employee();
		e.setEid(7);
		e.setName("sachin");
		
		m.addAttribute("employee", e);
		
		
		return "result1";
		
	}
	*/
	
	
	
	@RequestMapping("/addEmployee")
	public String addEmployees(@ModelAttribute("employee") Employee e) {
		r.save(e);
		
	
	//m.addAttribute("employee", e);
		
		
		return "result1";
		
	}
	
	@RequestMapping("getEmployees")
	public String getEmployees(Model m) {
		//List<Employee> l=Arrays.asList(new Employee(101, "sachin"),new Employee(102, "amol"));
		m.addAttribute("result",r.findAll());		
		
		return "showall";
		
	}	
	@RequestMapping("getEmployeeById")
	public String getEmployeeById(@RequestParam int eid,Model m) {
		m.addAttribute("result", r.getOne(eid));
		return "showall";
				
	}
	
	@RequestMapping("getEmployeeByNameOrdered")
	public String getEmployeeByName(@RequestParam String name,Model m) {
		m.addAttribute("result", r.getEmployeeByNameOrderByEidDesc(name));
		return "showall";
				
	}
	
	@RequestMapping("getEmployeeByNameQuery")
	public String getEmployeeByNameQuery(@RequestParam String name,Model m) {
		m.addAttribute("result", r.getEmployeeByNameQuery(name));
		return "showall";
				
	}
}
