package com.qa.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String description;
    @Column(updatable = false)

    private LocalDateTime created = LocalDateTime.now();
    @Column
    private String urgency;
    @Column
    private String topic;
    @Column
    private long completed;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ticket"})
    @OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER)
    private List<Solutions> solution = new ArrayList<>();

    public Ticket() {

    }
   
    public Ticket(String title, String author, String description, String urgency, String topic, long completed) {
        this.title = title;
        this.author = author;
        this.description = description;
//        this.time_created = time_created;
        this.urgency = urgency;
        this.topic = topic;
        this.completed = completed;
    }
    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
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

    public List<Solutions> getSolution() {
        return solution;
    }

    public void setSolution(List<Solutions> solution) {
        this.solution = solution;
    }

}
