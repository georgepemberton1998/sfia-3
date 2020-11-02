package com.qa.backend.domain;

import javax.persistence.*;

@Entity
public class Solutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String solutionDesc;
    @ManyToOne(targetEntity = Ticket.class)
    private Ticket ticket;

    public Solutions() {

    }
    public Solutions(String solutionDesc) {
        this.solutionDesc = solutionDesc;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSolutionDesc() {
        return solutionDesc;
    }

    public void setSolutionDesc(String solutionDesc) {
        this.solutionDesc = solutionDesc;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString(){
        return "Solution Description:" + solutionDesc;
    }
}
