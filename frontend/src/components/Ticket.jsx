import React from 'react';

const Ticket = props => {
    return (
        <div className="ticket">
            <h3>{props.title}</h3>
            <p><strong>Description: </strong> {props.description}</p>
            <p><strong>Topic: </strong> {props.topic}</p>
            <p><strong>Urgency: </strong> {props.urgency}</p>
            <p><strong>Author: </strong> {props.author}</p>
            <p><strong>Solution: </strong> {props.solutionDesc}</p><br/>
            <a className="buttons-update" href={props.updateURL}>Update Ticket</a>
            <a className="buttons-delete" href={props.deleteURL}>Delete Ticket</a>
        </div>

    );
}
export default Ticket;