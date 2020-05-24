package com.example.flywaydb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	    @Test
		public void retrievetest_ok() throws Exception {
		 addEmployee_ok();
			 mockMvc.perform(get("/1499427" )).andDo(print())
		                .andExpect(status().isOk())
		                .andExpect(MockMvcResultMatchers.jsonPath("$.emp_Id").value(1499427))
		                .andExpect(MockMvcResultMatchers.jsonPath("$.emp_Name").value("akhil"))
		                .andExpect(MockMvcResultMatchers.jsonPath("$.designation").value("ASE Trainee"))
		                .andExpect(MockMvcResultMatchers.jsonPath("$.contact_Number").value("7674813581"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("ak.gundu@gmail.com"));
	}

    @Test
	public void addEmployee_ok() throws Exception {
		Employee emp = new Employee();
			emp.setEmp_Id(1499427);
			emp.setEmp_Name("akhil");
			emp.setDesignation("ASE Trainee");
			emp.setContact_Number("7674813581");
			emp.setEmail("ak.gundu@gmail.com");
			byte[] empjson = toJson(emp);
			emp.setEmp_Id(123456);
			emp.setEmp_Name("jhon");
			emp.setDesignation("associate software Engineer");
			emp.setContact_Number("1234567891");
			emp.setEmail("jhon@tcs.com");
			byte[] empjson1 = toJson(emp);
			mockMvc.perform(post("/create")
					.content(empjson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
			mockMvc.perform(post("/create")
					.content(empjson1)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	}
	
	@Test
	public void updateEmployee_ok() throws Exception {
		Employee emp1 = new Employee();
		emp1.setEmp_Id(123456);
		emp1.setEmp_Name("jhon");
		emp1.setDesignation("software Engineer");
		emp1.setContact_Number("1234567891");
		emp1.setEmail("jhon@tcs.com");
		byte[] empjson1 = toJson(emp1);
		mockMvc.perform(put("/update")
				.content(empjson1)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
		mockMvc.perform(get("/123456" )).andDo(print())
		.andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.emp_Name").value("jhon"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.designation").value("software Engineer"));		
	}
	
	@Test
	public void deleteEmployee_ok() throws Exception{
		Employee emp = new Employee();
		emp.setEmp_Id(123456);
		emp.setEmp_Name("jhon");
		emp.setDesignation("software Engineer");
		emp.setContact_Number("1234567891");
		emp.setEmail("jhon@tcs.com");
		byte[] empjson1 = toJson(emp);
		mockMvc.perform(delete("/delete/123456")
				.content(empjson1)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}
	
	 private byte[] toJson(Object r) throws Exception {
	        ObjectMapper map = new ObjectMapper();
	        return map.writeValueAsString(r).getBytes();
	    }
}
