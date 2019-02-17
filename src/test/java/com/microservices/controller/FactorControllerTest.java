package com.microservices.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.beans.Factor;
import com.microservices.beans.Price;
import com.microservices.services.FactorService;

@RunWith(SpringRunner.class)
@WebMvcTest(FactorController.class)
public class FactorControllerTest {
    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private FactorService service;
 
    @Test
    public void test_factor_service_normal()
      throws Exception {
         
		Price price = new Price.PriceBuilder()
				.setGrossPrice(new Double("5000"))
				.setNetPrice(new Double("4000"))
				.setTechnicalPrice(new Double("3000"))
				.build();
     
        given(service.delegateCalculation("QC")).willReturn(price);

        mvc.perform(post("/factor-services")
          .contentType(MediaType.APPLICATION_JSON).content(generateJsonForQCLocation()))
          .andExpect(status().isOk());
    }

    private String generateJsonForQCLocation() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Factor factor = new Factor();
        factor.setFloodFactor(3);
        factor.setBuildingSafetyFactor(4);
        factor.setLocation("QC");
        
        return mapper.writeValueAsString(factor);
    }



}
