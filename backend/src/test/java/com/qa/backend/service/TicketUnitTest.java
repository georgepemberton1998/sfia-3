package com.qa.backend.service;


import com.qa.backend.domain.Ticket;
import com.qa.backend.dto.TicketDTO;
import com.qa.backend.rest.TicketController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class TicketUnitTest {
    @InjectMocks
    private TicketController ticketController;

    @Mock
    private TicketService ticketService;

    private List<Ticket> ticketList;

    private Ticket testTicket;

    private final long id = 1L;

    private Ticket testTicketWithID;

    private TicketDTO ticketDTO;

    private final ModelMapper modelMapper = new ModelMapper();

    private TicketDTO mapToDTO(Ticket ticket) {
        return this.modelMapper.map(ticket, TicketDTO.class);
    }

    @Before
    public void setUp(){
        this.ticketList = new ArrayList<>();
        this.testTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", false);
        ticketList.add(testTicket);
        this.testTicketWithID = new Ticket(testTicket.getTitle(), testTicket.getAuthor(), testTicket.getDescription(), testTicket.getUrgency(), testTicket.getTopic(), testTicket.getCompleted());
        this.testTicketWithID.setId(id);
        this.ticketDTO = this.mapToDTO(testTicketWithID);
    }


    @org.junit.Test
    public void getAllTicketsTest() {
        when(ticketService.getTickets())
                .thenReturn(this.ticketList.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("Controller has found no tickets", this.ticketController.getTickets().getBody().isEmpty());
        verify(ticketService, times(1)).getTickets();
    }

    @org.junit.Test
    public void createTicketTest() {
        when(this.ticketService.createTicket(testTicket)).thenReturn(this.ticketDTO);
        assertEquals(new ResponseEntity<TicketDTO>(this.ticketDTO, HttpStatus.CREATED), this.ticketController.createTicket(testTicket));
        verify(this.ticketService, times(1)).createTicket(this.testTicket);
    }

    @org.junit.Test
    public void deleteTicketTest() {
        this.ticketController.deleteTicket(id);
        verify(this.ticketService, times(1)).deleteTicket(id);
    }

    @org.junit.Test
    public void findTicketByIDTest() {
        when(this.ticketService.findTicketById(this.id))
                .thenReturn(this.ticketDTO);
        assertEquals(
                new ResponseEntity<TicketDTO>(this.ticketDTO, HttpStatus.OK),
                this.ticketController.getTicketById(this.id)
        );
        verify(this.ticketService, times(1)).findTicketById(this.id);
    }

    @org.junit.Test
    public void updateTicketTest() {
        Ticket newTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "SoftwareDev", false);
        Ticket updateTicket = new Ticket(newTicket.getTitle(), newTicket.getAuthor(), newTicket.getDescription(), newTicket.getUrgency(), newTicket.getTopic(), newTicket.getCompleted());
        updateTicket.setId(this.id);
        when(this.ticketService.updateTicket(this.id, newTicket)).thenReturn(this.mapToDTO(updateTicket));
        assertEquals(new ResponseEntity<TicketDTO>(this.mapToDTO(updateTicket), HttpStatus.ACCEPTED), this.ticketController.updateTicket(this.id, newTicket));
        verify(this.ticketService, times(1)).updateTicket(this.id, newTicket);
    }



}
