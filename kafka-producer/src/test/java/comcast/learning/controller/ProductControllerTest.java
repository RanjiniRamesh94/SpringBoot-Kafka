/*package comcast.learning.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import comcast.learning.model.Product;
import comcast.learning.repository.ProductRepo;

public class ProductControllerTest {
	
	
	private static final Logger log = LoggerFactory.getLogger(ProductControllerTest.class);

	@Autowired
	ProductRepo repo;
	
	protected Product product1;
	protected Product product2;
	protected Product product3;
	
	
	@Before
	public void setData() {

		product1 = new Product(1,"Sample1");
		product2 = new Product(2, "Sample2");
		product3 = new Product(3, "Sample3");
		repo.save(product1);
	}
	
	
	@Test
	public void testCreateProduct() throws Exception {
		
		String requestJson = new ObjectMapper().writeValueAsString(product1);
		this.mockMvc.perform(post("/customer/create").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.address", is("Chennai")));
	}
	
	
}
*/