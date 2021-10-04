package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.entity.Restaurant;
import com.example.demo.services.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;




@SpringBootTest
@AutoConfigureMockMvc
class RestaurantInfoServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper  mapper;
    
    @MockBean
    RestaurantService service;
    
    Restaurant RECORD_1 = new Restaurant(101,"Kamat Hotel","chennai","veg",3.5);
    Restaurant RECORD_2 = new Restaurant(102,"Sanskriti Hotel","rajgarh","veg",4.3);
    Restaurant RECORD_3 = new Restaurant(103,"Atiksh Hotel","rajgarh","veg",5);
    
    @Test
    void getAllRecords_success() throws Exception {
       List<Restaurant> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
       
       given(service.findAll()).willReturn(records);

       mockMvc.perform(MockMvcRequestBuilders
               .get("/restaurants")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(3)))
               .andExpect(jsonPath("$[2].restaurantName", is("Atiksh Hotel")));
   }
    
    @Test
    public void findRecordById_success() throws Exception {
    	given(service.findById(RECORD_3.getId())).willReturn(RECORD_3);
    	mockMvc.perform(MockMvcRequestBuilders
    			.get("/restaurants/103")
    			.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.restaurantName", is("Atiksh Hotel")));
    }
    
    @Test
    public void add_success() throws Exception {
    	Restaurant RECORD_4 = new Restaurant(104,"Taj Hotel","Mumbai","both",4.9);
    	given(service.add(RECORD_4)).willReturn(RECORD_4);
    	mockMvc.perform(MockMvcRequestBuilders
    			.post("/restaurants")
    			.content(mapper.writeValueAsString(RECORD_4))
    			.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isCreated())
		        .andExpect(jsonPath("$.id", is(104)));
    }
    
    @Test
    public void deleteRecordById_success() throws Exception {
    	given(service.deleteById(RECORD_2.getId())).willReturn(RECORD_2);
    	mockMvc.perform(MockMvcRequestBuilders
    			.delete("/restaurants/102")
    			.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isAccepted())
		        .andExpect(jsonPath("$.restaurantName", is("Sanskriti Hotel")));
    }

}
