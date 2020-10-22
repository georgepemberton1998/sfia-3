import React from 'react';
import {useParams} from 'react-router-dom';

const DeleteTicket = () => {
    let {id} = useParams(); //gets id passed through URL 
    return (

        <p>Delete ticket id: {id}</p>

    );
}

export default DeleteTicket;