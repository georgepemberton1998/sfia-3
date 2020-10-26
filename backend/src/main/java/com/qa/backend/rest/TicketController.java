package com.qa.backend.rest;

import com.qa.backend.domain.Ticket;
import com.qa.backend.dto.TicketDTO;
import com.qa.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TicketController {
    private final TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket/getTickets")
    public ResponseEntity<List<TicketDTO>> getTickets(){
        return ResponseEntity.ok(this.ticketService.getTickets());
    }

    @PostMapping("/ticket/createTicket")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<TicketDTO>(this.ticketService.createTicket(ticket), HttpStatus.CREATED);
    }

    @PutMapping("/ticket/updateTicket/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket){
        return ResponseEntity.ok(this.ticketService.updateTicket(id, ticket));
    }

    @DeleteMapping("/ticket/deleteTicket/{id}")
    public Boolean deleteTicket(@PathVariable Long id){
        return this.ticketService.deleteTicket(id);
    }

    @GetMapping("/ticket/getTicketById/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id){
        return ResponseEntity.ok(this.ticketService.findTicketById(id));
    }
}
