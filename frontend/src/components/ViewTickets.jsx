import React from 'react';
import axios from 'axios';

const ViewTickets = () => {
    axios.get('http://localhost:8082/ticket/getTickets')
    .then((response) => {
        console.log(response.data);
    });
    return (

        <p>Tickets here</p>

    );
}

export default ViewTickets;