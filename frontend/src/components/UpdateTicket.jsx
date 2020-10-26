import React, {useState, useEffect} from 'react';
import {useParams} from 'react-router-dom';
import axios from 'axios';

const UpdateTicket = () => {
  let {id} = useParams(); //gets id passed through URL
    let [title, setTitle] = useState('');
    let [author, setAuthor] = useState('');
    let [description, setDescription] = useState('');
    let [topic, setTopic] = useState('');
    let [urgency, setUrgency] = useState('');
    let [completed, setCompleted] = useState(0);
    useEffect(() => {
        
        const url = "http://localhost:8082/ticket/getTicketById/" + id;
        console.log(url);
        axios.get(url)
        .then(res => {
          setTitle(res.data.title);
          setAuthor(res.data.author);
          setDescription(res.data.description);
          setUrgency(res.data.urgency);
          setTopic(res.data.topic);
          setCompleted(res.data.completed);
        }) 
    
      }, [id]);



    const updateTicket = () => {
      const url = "http://localhost:8082/ticket/updateTicket/" + id;
        if(title === "" || author === "" || description === "" || topic === "" || urgency === "") {
            alert("Please complete the ticket request before submitting");
        }
        else {
        axios.put(url,{
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
        window.location.replace("/");
        alert("Ticket Updated");

    }
    }

    return (

        <>
            <div className="form">
                <form onSubmit={updateTicket}>
                    

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
                    <label>Status</label>

                    <select name="completed" value={completed} onChange={e => setCompleted(e.target.value)}>
                        <option value="0">Incomplete</option>
                        <option value="1">Complete</option>
                        </select>


                    <input type="submit" value="Update Ticket"/>

                </form>

            </div>
    
        

        </>
    );
}
export default UpdateTicket;