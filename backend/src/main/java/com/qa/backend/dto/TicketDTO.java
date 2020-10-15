package com.qa.backend.dto;

import com.qa.backend.domain.Solutions;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TicketDTO {

    private long id;
    private String title;
    private String author;
    private String description;
    private Timestamp time_created;
    private String urgency;
    private String topic;
    private long completed;
    private List<Solutions> solution = new ArrayList<>();

    public TicketDTO() {

    }

    public TicketDTO(String title, String author, String description, Timestamp time_created, String urgency, String topic, long completed) {
        super();
        this.title = title;
        this.author = author;
        this.description = description;
        this.time_created = time_created;
        this.urgency = urgency;
        this.topic = topic;
        this.completed = completed;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTime_created() {
        return time_created;
    }

    public void setTime_created(Timestamp time_created) {
        this.time_created = time_created;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
        this.completed = completed;
    }

    public List<Solutions> getSolution() {
        return solution;
    }

    public void setSolution(List<Solutions> solution) {
        this.solution = solution;
    }


}
