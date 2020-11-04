import React, {useState, useEffect} from 'react';
import axios from 'axios';
import Ticket from './Ticket';

const ViewTickets = () => {
    const [tickets, setTickets] = useState([]);
    const updateUrl = "update/";
    const deleteUrl = "delete/";
  
    useEffect(() => {
      axios
        .get("/api/ticket/getTickets")
        .then((data) => data)
        .then((result) => {

            setTickets(result.data);

  
          }, 
        );
    }, []);
    return (
      <>
        <main>
            <div className="incompleteTickets">
                <h3>Incomplete Tickets</h3>
                {tickets.filter(ticket => ticket.completed === false).map((ticket) => (
                  <Ticket key={ticket.id} title={ticket.title} topic={ticket.topic} description={ticket.description} urgency={ticket.urgency} author={ticket.author} solutionDesc={ticket.solutionDesc} updateURL={updateUrl + ticket.id} deleteURL={deleteUrl + ticket.id}/>

                ))}
            </div>

              <div className="completeTickets">
                <h3>Complete Tickets</h3>
                {tickets.filter(ticket => ticket.completed === true).map((ticket) => (
                  <Ticket key={ticket.id} title={ticket.title} topic={ticket.topic} description={ticket.description} urgency={ticket.urgency} author={ticket.author} solutionDesc={ticket.solutionDesc} updateURL={updateUrl + ticket.id} deleteURL={deleteUrl + ticket.id}/>

                ))}
              </div>
        </main>

      </>
    );
}

export default ViewTickets;