import React from 'react';
import {useParams} from 'react-router-dom';

const UpdateTicket = () => {
    let {id} = useParams(); //gets id passed through URL
    return (

        <p>Update ticket id: {id}</p>

    );
}

export default UpdateTicket;