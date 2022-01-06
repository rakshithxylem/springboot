package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.customexception.BusinessException;
import com.employee.customexception.ControllerException;
import com.employee.entity.Employee;
import com.employee.service.EmployeeServiceInterf;
//import com.entity.Employee;

@RestController
@RequestMapping("/code")
public class EmployeeController {

	@Autowired
private	EmployeeServiceInterf empservice;
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		try {
		
		Employee employeeSaved=empservice.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved,HttpStatus.CREATED);
		}catch (BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);

		}catch (Exception e) {
			ControllerException ce=new ControllerException("611","SOMETHING WENT WRONG IS CONTROLLER");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> listOfAllEmp=empservice.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfAllEmp,HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("empid") Long empidL){
		try {
			Employee empRetrived=empservice.getEmpById(empidL);
			return new ResponseEntity<Employee>(empRetrived,HttpStatus.OK);

		}catch (BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);

		}catch (Exception e) {
			ControllerException ce=new ControllerException("612","SOMETHING WENT WRONG IS CONTROLLER");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
		}
			}
	
	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("empid") Long empidL){
		try {
			 empservice.deleteEmpById(empidL);
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}catch (BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);

		}catch (Exception e) {
			ControllerException ce=new ControllerException("613","SOMETHING WENT WRONG IS CONTROLLER");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
		}
	     
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
		try {
			Employee employeeSaved=empservice.addEmployee(employee);
			return new ResponseEntity<Employee>(employeeSaved,HttpStatus.CREATED);
	
		}catch (BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);

		}catch (Exception e) {
			ControllerException ce=new ControllerException("611","SOMETHING WENT WRONG IS CONTROLLER");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
		}
			}
	
	
}
