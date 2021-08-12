package com.inventory.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;


@SpringBootTest
@AutoConfigureMockMvc
class ProjectInvtApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	/*
	 * @Test void contextLoads() throws Exception {
	 * 
	 * mockMvc.perform(get("/product/show")).andExpect(status().isOk()).andExpect(
	 * content().string("[]"));
	 * 
	 * }
	 */
	
	@Test
	void index() throws Exception {
		String json="{\n" + 
				"	\"id\":2,\n" + 
				"	\"name\": \"TV\",\n" + 
				"	\"descriptions\":\"LG TV\",\n" + 
				"	\"price\" : 20000.0,\n" + 
				"	\"quantity\" : 5\n" + 
				"}";
		MvcResult result = mockMvc.perform(post("/product/insert")
			    .contentType(MediaType.APPLICATION_JSON)
			    .content(json)
			    .characterEncoding("utf-8"))
			    .andExpect(status().isCreated())
			    .andReturn();
		String resp=result.getResponse().toString();
		System.out.println("----------------"+resp);
		Assertions.assertEquals("OK", resp);
	}

}
