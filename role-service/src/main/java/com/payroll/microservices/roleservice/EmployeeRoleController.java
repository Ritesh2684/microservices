package com.payroll.microservices.roleservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRoleController {
	
	private static Logger log = LoggerFactory.getLogger(EmployeeRoleController.class);
	
	@Autowired
	EmployeeRoleRepository employeeRoleRepository;
	
	@GetMapping("/role/{roleName}")
	public EmployeeRole getRoleByRoleName(@PathVariable String roleName){
		
		log.info("Inside getRoleByRoleName");
		
		return employeeRoleRepository.findByRoleName(roleName);
	//	return new EmployeeRole(101L,"HR","Human Resources");
	}
	

}
