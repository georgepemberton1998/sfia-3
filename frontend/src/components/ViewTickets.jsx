import React, {useState, useEffect} from 'react';
import axios from 'axios';

const ViewTickets = () => {
    const [tickets, setTickets] = useState([]);
    const updateUrl = "update/";
    const deleteUrl = "delete/";
  
    useEffect(() => {
      axios
        .get("http://localhost:8082/ticket/getTickets")
        .then((data) => data)
        .then((result) => {

            setTickets(result.data);

  
          }, 
        );
    }, []);
    return (
        <div>
        {console.log(tickets)}
        {tickets.map((ticket) => (
          <li key={ticket.id}>
            Title: {ticket.title}<br/>
            Topic: {ticket.topic}<br/>
            Author: {ticket.author} <br/>
            Description: {ticket.description}<br/>
            Urgency: {ticket.urgency}<br/>

           <a href={updateUrl + ticket.id}>Update Ticket</a><br/>
           <a href={deleteUrl + ticket.id}>Delete Ticket</a>
           
          </li>
        ))}
    
        </div>

    );
}

export default ViewTickets;