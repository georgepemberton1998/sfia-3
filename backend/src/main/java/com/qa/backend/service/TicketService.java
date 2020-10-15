package com.qa.backend.service;

import com.qa.backend.domain.Ticket;
import com.qa.backend.dto.TicketDTO;
import com.qa.backend.exceptions.TicketNotFoundException;
import com.qa.backend.repo.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ModelMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }
    private TicketDTO mapToDTO(Ticket ticket){
        return this.mapper.map(ticket, TicketDTO.class);
    }

    public List<TicketDTO> getTickets(){
        return this.ticketRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public TicketDTO createTicket(Ticket ticket){
        return this.mapToDTO(this.ticketRepository.save(ticket));
    }

    public TicketDTO findTicketById(Long id){
        return this.mapToDTO(this.ticketRepository.findById(id)
                .orElseThrow(TicketNotFoundException::new));    }

    public TicketDTO updateTicket(Long id, Ticket ticket){
        Ticket update = this.ticketRepository.findById(id).orElseThrow(TicketNotFoundException::new);
        update.setAuthor(ticket.getAuthor());
        update.setCompleted(ticket.getCompleted());
        update.setDescription(ticket.getDescription());
        update.setTitle(ticket.getTitle());
        update.setTopic(ticket.getTopic());
        update.setUrgency(ticket.getUrgency());
        return this.mapToDTO(this.ticketRepository.save(update));
    }

    public Boolean deleteTicket(Long id){
        if(!this.ticketRepository.existsById(id)){
            throw new TicketNotFoundException();
        }
        this.ticketRepository.deleteById(id);
        return this.ticketRepository.existsById(id);
    }


}
