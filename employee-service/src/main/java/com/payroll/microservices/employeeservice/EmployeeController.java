package com.payroll.microservices.employeeservice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class EmployeeController {
	
	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	Environment environment;
	
	@Autowired
	EmployeeConfiguration employeeConfiguration;
	
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeDetails(@PathVariable Long empId){
		
		log.info("Inside getEmployeeDetails");
		Employee employee =  employeeRepository.findOne(empId);
		
		employee.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		//return new Employee("AAA","BB",1L,new Date());
		
		return employee;
	}
	
	@GetMapping("/employee/fault-tolerance")
	@HystrixCommand(fallbackMethod="fallBackEmployeeDetails")
	public Employee getEmployeeDetailsFaultTolerance(){
		
		throw new RuntimeException("new issue");
		
	}
	
	public Employee fallBackEmployeeDetails(){
		return new Employee(employeeConfiguration.getFirstName(), employeeConfiguration.getLastName(), 101L, new Date());
	}

}
