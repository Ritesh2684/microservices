package com.payroll.microservices.employeepayrollservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePayrollController {
	
	private static Logger log = LoggerFactory.getLogger(EmployeePayrollController.class);
	
	@Autowired
	EmployeePayrollRepository employeePayrollRepository;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	RoleService roleService;
	
	
	@PostMapping("/employee/{empId}/role/{roleName}")
	public EmployeePayroll insertEmployeePayrollDetails(@PathVariable Long empId, @PathVariable String roleName){
		//EmployeePayroll employeePayroll = new EmployeePayroll(1L, 100L, "AAA", "BBB", 100L, "HR", "Human Resources");
		log.info("Inside insertEmployeePayrollDetails");
		//ResponseEntity<EmployeePayroll> employeeEntity = new RestTemplate().getForEntity("http://localhost:8080/employee/{empId}", EmployeePayroll.class, empId);
		EmployeePayroll employeePayroll = employeeService.getEmployeeDetails(empId);
		// ResponseEntity<EmployeePayroll> roleEntity = new RestTemplate().getForEntity("http://localhost:8101/role/{roleName}", EmployeePayroll.class, roleName);
		//EmployeePayroll employeePayroll = employeeEntity.getBody();
		EmployeePayroll roleDetails = roleService.getRoleByRoleName(roleName);
		employeePayroll.setRoleId(roleDetails.getRoleId());
		employeePayroll.setRoleName(roleDetails.getRoleName());
		employeePayroll.setDescription(roleDetails.getDescription());
		employeePayrollRepository.save(employeePayroll);
		
		return employeePayroll;
	}

}
