package com.payroll.microservices.employeepayrollservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="employee-service", url="localhost:8080")
//@FeignClient(name="employee-service")
@FeignClient(name="zuul-edge-server")
@RibbonClient(name="employee-service")
public interface EmployeeService {
	
	@GetMapping("/employee-service/employee/{empId}")
	public EmployeePayroll getEmployeeDetails(@PathVariable("empId") Long empId);

}
