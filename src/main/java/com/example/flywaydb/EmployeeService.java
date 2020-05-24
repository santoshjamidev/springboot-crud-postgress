package com.example.flywaydb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer emp_Id) {

        System.out.println("getEmployeeById.."+ emp_Id);

        return employeeRepository.findById(emp_Id).get();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public Employee updateEmployee(Employee employee) {

        System.out.println("updateEmployee..");
        if (employeeRepository.findById(employee.getEmp_Id()).isPresent()) {
            Employee employee1 = employeeRepository.findById(employee.getEmp_Id()).get();

            employee1.setEmp_Id(employee.getEmp_Id());
            employee1.setContact_Number(employee.getContact_Number());
            employee1.setDesignation(employee.getDesignation());
            employee1.setEmail(employee.getEmail());
            employee1.setEmp_Name(employee.getEmp_Name());

            return employeeRepository.save(employee1);
        }

        Employee result = employeeRepository.save(employee);
        return result;
    }

    public void updateEmployee(Integer emp_Id) {
        employeeRepository.deleteById(emp_Id);
    }
	
}
