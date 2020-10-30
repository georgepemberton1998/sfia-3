package com.qa.backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.backend.domain.Solutions;
import com.qa.backend.domain.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

@AutoConfigureMockMvc

@ActiveProfiles(profiles = "test")

@Sql(scripts = {"classpath:schema.sql",
                "classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class SolutionsIntegrationTest {

     @Autowired
    private MockMvc mockMVC;

    @Autowired
    private ObjectMapper mapper;


    @Test
    void createSolution() throws Exception {

        Solutions newSolution = new Solutions("nginx");

        String testSolutionAsJSON = this.mapper.writeValueAsString(newSolution);
        RequestBuilder request = post("/solutions/createSolution").contentType(MediaType.APPLICATION_JSON).content(testSolutionAsJSON);

        ResultMatcher checkStatus = status().is(201);

        Solutions savedSolution = new Solutions("nginx");
        savedSolution.setId(2L);

        MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();

//        String reqBody = result.getResponse().getContentAsString();
//        Solutions solutionResult = this.mapper.readValue(reqBody, Solutions.class);
    }

    @Test
    void updateSolutions() throws Exception {
        Solutions newSolutions = new Solutions("nginx");
        String testSolutionsAsJSON = this.mapper.writeValueAsString(newSolutions);
        RequestBuilder request = put("/solutions/updateSolution/1").contentType(MediaType.APPLICATION_JSON).content(testSolutionsAsJSON);

        ResultMatcher checkStatus = status().is(202);

        Solutions savedSolutions = new Solutions("nginx");
        savedSolutions.setId(1L);


        MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();
        String reqBody = result.getResponse().getContentAsString();
        Solutions solutionsResult = this.mapper.readValue(reqBody, Solutions.class);
        assertThat(solutionsResult).isEqualToIgnoringGivenFields(savedSolutions, "created").hasNoNullFieldsOrProperties();
    }

    @Test
	public void deleteSolution() throws Exception{
		this.mockMVC.perform(delete("/solutions/deleteSolution/1")).andExpect(status().isNoContent());
	}

	@Test
	void getSolution() throws Exception{
		Solutions solution  = new Solutions("nginx");
		solution.setId(1L);
		List<Solutions> solutions = new ArrayList<>();
		solutions.add(solution);
		String responseBody = this.mapper.writeValueAsString(solutions);

		this.mockMVC.perform(get("/solutions/getSolutions")).andExpect(status().isOk()).andExpect(content().json(responseBody));
        assertThat(solution).isEqualToIgnoringGivenFields(solution, "ticket_id").hasNoNullFieldsOrProperties();
	}
}
