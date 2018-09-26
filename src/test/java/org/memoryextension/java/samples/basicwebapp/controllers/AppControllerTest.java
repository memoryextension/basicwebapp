package org.memoryextension.java.samples.basicwebapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.memoryextension.java.samples.basicwebapp.controllers.AppController;
import org.memoryextension.java.samples.basicwebapp.pojos.PingPong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
public class AppControllerTest {

	@Autowired
	private WebApplicationContext wac;


	private MockMvc mockMvc;

	private PingPong pp = new PingPong(3,67);

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void viewHWTest() throws Exception {
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk());
	}

	@Test
	public void ppSaveTest() throws Exception {
		mockMvc.perform(
			post(AppController.URL_FORM)
				.contentType( MediaType.APPLICATION_FORM_URLENCODED)
				.param( "save", "PingPong it" )
				.param( "start", "1" )
				.param( "end", "83" ))
			.andExpect(status().isOk());
			
	}

}
