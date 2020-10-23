import React, {useState} from 'react';
import axios from 'axios';

const CreateTicket = () => {
    let [title, setTitle] = useState('');
    let [author, setAuthor] = useState('');
    let [description, setDescription] = useState('');
    let [topic, setTopic] = useState('');
    let [urgency, setUrgency] = useState('');
    const completed = 0;
    const ticketCreate = () => {
        if(title === "" || author === "" || description === "" || topic === "" || urgency === "") {
            alert("Please complete the ticket request before submitting");
        }
        else {
        axios.post('http://localhost:8082/ticket/createTicket/',{
            title: title,
            author: author,
            description: description,
            urgency: urgency,
            topic: topic,
            completed: completed
        })
        .then(function (response) {
            console.log(response);

        })
        .catch(function (error) {
            console.log(error);

        });
    }
    }

    return (

        <>
            <form onSubmit={ticketCreate}>

                <label>Title:</label>
                <input type="text" name="title" value={title} onChange={e => setTitle(e.target.value)}/>

                <label>Author:</label>
                <input type="text" name="author" value={author} onChange={e => setAuthor(e.target.value)}/>

                <label>Description of issue:</label>
                <input type="text" name="description" value={description} onChange={e => setDescription(e.target.value)}/>

                <label>Topic:</label>
                <select name="topic" value={topic} onChange={e => setTopic(e.target.value)}>
                    <option value="">Select a topic</option>
                    <option value="Software">Software</option>
                    <option value="Hardware">Hardware</option>
                    <option value="Other">Other</option>
                </select>

                <label>Urgency</label>
                <select name="urgency" value={urgency} onChange={e => setUrgency(e.target.value)}>
                    <option value="">Select Ticket Urgency</option>
                    <option value="Very Urgent">Very Urgent</option>
                    <option value="Urgent">Urgent</option>
                    <option value="Not Urgent">Not Urgent</option>
                </select>

                <input type="submit" value="Create Ticket"/>

            </form>
        </>

    );
}

export default CreateTicket;