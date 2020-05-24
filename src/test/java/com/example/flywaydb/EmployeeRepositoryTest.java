package com.example.flywaydb;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
 @Autowired
 private EmployeeRepository employeeRepository;
 
    @Test
 public void testFinfById() {
	 entityManager.persist(new Employee(1499427,"akhil","software","7674813581","ak.gundu@gmail.com"));
	 Optional<Employee> emp = employeeRepository.findById(1499427); 
     assertEquals("7674813581",emp.get().getContact_Number());
 }
}
