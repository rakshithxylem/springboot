package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeServiceInterf {

public	Employee addEmployee(Employee employee);

public List<Employee> getAllEmployees();

public Employee getEmpById(Long empidL);

public void deleteEmpById(Long empidL);

}
