import React from 'react';
import logo from './images/qa-logo.png';

const Navigation = () => {
    return (
        <>
        <nav>
            <a href="http://qa.com/"><img className="logo" src={logo} alt="logo"></img></a>
            <a href="/">View Tickets</a>
            <a href="/createTicket">Create Ticket</a>
        </nav>

        </>

    )
}

export default Navigation;