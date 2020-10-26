import React, {useEffect} from 'react';
import {useParams} from 'react-router-dom';
import axios from 'axios';

const DeleteTicket = () => {
    let {id} = useParams(); //gets id passed through URL 
    useEffect(() => {
        
        const url = "http://localhost:8082/ticket/deleteTicket/" + id;
        console.log(url);
        axios.delete(url)
        .then(res => {
            alert("Ticket deleted");
            window.location.replace("/");

        }) 
    
      }, [id]);
    return (

        <p>Deleted ticket id: {id}</p>

    );
}

export default DeleteTicket;