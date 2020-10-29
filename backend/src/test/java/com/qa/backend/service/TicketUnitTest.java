package com.qa.backend.service;


import com.qa.backend.domain.Ticket;
import com.qa.backend.dto.TicketDTO;
import com.qa.backend.repo.TicketRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TicketUnitTest {

    @Autowired
    private TicketService service;

    @MockBean
    private TicketRepository repo;

    private ModelMapper mapper;

    //GIVEN - WHEN - THEN
//    @Test
//    public void testCreate() {
//        //GIVEN
//        Long id = 1L;
//        Ticket newTicket = new Ticket("nginx", "keenan", "help meh", "very urgent", "DevOps", 0);
//        TicketDTO savedTicket = new TicketDTO("nginx", "keenan", "help meh", "very urgent", "DevOps", 0);
//        savedTicket.setId(id);
//
//        //WHEN
//        Mockito.when(this.repo.save(newTicket)).thenReturn(this.mapper.map(newTicket, TicketDTO.class));
//
//        //THEN
//        assertThat(this.service.createTicket(newTicket)).isEqualTo(savedTicket);
//
//        Mockito.verify(this.repo, Mockito.times(1)).save(newTicket);
//    }

}
