package com.example.flywaydb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public List<Employee> getAllEmployees() {

    return employeeService.getAllEmployees();
  }

  @GetMapping(path = "/{emp_id}")
  public Employee getEmployeeById(@PathVariable("emp_id") Integer emp_Id) {
    return employeeService.getEmployeeById(emp_Id);
  }

  @PostMapping(path = "/create")
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @PutMapping(path = "/update")
  public Employee updateEmployee(@RequestBody Employee employee) {

    return employeeService.updateEmployee(employee);
  }

  @DeleteMapping(path = "/delete/{emp_id}")
  public void updateEmployee(@PathVariable("emp_id") Integer emp_Id) {
    employeeService.updateEmployee(emp_Id);
  }

}
