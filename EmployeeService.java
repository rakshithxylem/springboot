package com.employee.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.customexception.BusinessException;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class EmployeeService implements EmployeeServiceInterf {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		
		
if(employee.getName().isEmpty() || employee.getName().length()==0) {
	throw new BusinessException("601", "please send proper name, its blank");
}

try {
			Employee SavedEmployee=employeeRepository.save(employee);
			return SavedEmployee;
		}catch (IllegalArgumentException e) {
			throw new BusinessException("602", "given employee is null"+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("603", "something went wrong in service layer while saving employee"+e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList=null;

		
		try {
			 empList=employeeRepository.findAll();
		}catch (Exception e) {
			throw new BusinessException("606", "given  employee  is null"+e.getMessage());

		}
		if(empList.isEmpty()) 
			throw new BusinessException("604", "list is completely empty, we have nothing to return");
			return empList;
		
		
	}
	@Override
	public Employee getEmpById(Long empidL) {
		try {
			return employeeRepository.findById(empidL).get();
		}catch (IllegalArgumentException e) {
		throw new BusinessException("606", "given employee is id doesnot exist in database"+e.getMessage());
		}
		
		
	}

	@Override
	public void deleteEmpById(Long empidL) {
		try {
			employeeRepository.deleteById(empidL);

		}catch (IllegalArgumentException e) {
	throw new BusinessException("607", "given employee is id doesnot exist in database"+e.getMessage());
		}
		
	}
	
	
}
