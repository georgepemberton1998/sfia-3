package com.qa.backend.service;

import com.qa.backend.repo.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;
    @Autowired
    public TicketService(TicketRepository ticketRepository, ModelMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }


}
