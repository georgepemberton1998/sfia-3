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
    void updateSolution() throws Exception {
        Ticket newTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", 0);
        String testTicketAsJSON = this.mapper.writeValueAsString(newTicket);
        RequestBuilder request = put("/ticket/updateTicket/1").contentType(MediaType.APPLICATION_JSON).content(testTicketAsJSON);

        ResultMatcher checkStatus = status().is(202);

        Ticket savedTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", 0);
        savedTicket.setId(1L);

        MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();
        String reqBody = result.getResponse().getContentAsString();
        Ticket ticketResult = this.mapper.readValue(reqBody, Ticket.class);
        assertThat(ticketResult).isEqualToIgnoringGivenFields(savedTicket, "created").hasNoNullFieldsOrProperties();
    }
}
