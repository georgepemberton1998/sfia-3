package com.qa.backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.backend.domain.Ticket;
import com.qa.backend.dto.TicketDTO;
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

public class TicketIntegrationTest {

    @Autowired
    private MockMvc mockMVC;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void createTicket() throws Exception {


        Ticket newTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", false);

        String testTicketAsJSON = this.mapper.writeValueAsString(newTicket);
        RequestBuilder request = post("/ticket/createTicket").contentType(MediaType.APPLICATION_JSON).content(testTicketAsJSON);

        ResultMatcher checkStatus = status().is(201);

        Ticket savedTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", false);
        savedTicket.setId(2L);

        MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();

        String reqBody = result.getResponse().getContentAsString();
        Ticket ticketResult = this.mapper.readValue(reqBody, Ticket.class);
        assertThat(ticketResult).isEqualToIgnoringGivenFields(savedTicket, "created").hasNoNullFieldsOrProperties();
    }

    @Test
    void updateTicket() throws Exception {
        Ticket newTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", false);
        String testTicketAsJSON = this.mapper.writeValueAsString(newTicket);
        RequestBuilder request = put("/ticket/updateTicket/1").contentType(MediaType.APPLICATION_JSON).content(testTicketAsJSON);

        ResultMatcher checkStatus = status().is(202);

        Ticket savedTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", false);
        savedTicket.setId(1L);

        MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();
        String reqBody = result.getResponse().getContentAsString();
        Ticket ticketResult = this.mapper.readValue(reqBody, Ticket.class);
        assertThat(ticketResult).isEqualToIgnoringGivenFields(savedTicket, "created").hasNoNullFieldsOrProperties();
    }

    @Test
	public void deleteTicket() throws Exception{
		this.mockMVC.perform(delete("/ticket/deleteTicket/1")).andExpect(status().isOk());
	}

	@Test
	void getTicketById() throws Exception{
		TicketDTO ticket  = new TicketDTO("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", false);
        ticket.setId(1L);

//		List<Ticket> tickets = new ArrayList<>();
//		tickets.add(ticket);
		String responseBody = this.mapper.writeValueAsString(ticket);

		this.mockMVC.perform(get("/ticket/getTicketById/1")).andExpect(status().isOk()).andExpect(content().json(responseBody));
        assertThat(ticket).isEqualToIgnoringGivenFields(ticket, "created").hasNoNullFieldsOrProperties();
	}
}