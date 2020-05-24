package com.example.flywaydb;

import org.junit.Test;
import org.mockito.Mockito;

public class EmployeeServiceTest {

	private EmployeeService employeeService;
	private EmployeeRepository employeeRepositoryMock;
	
	public void setUp() {
		employeeRepositoryMock=Mockito.mock(EmployeeRepository.class);
		employeeService = new EmployeeService();
	}
	@Test
    public void createClientSuccessfuly() throws Exception {
		
	}
}
