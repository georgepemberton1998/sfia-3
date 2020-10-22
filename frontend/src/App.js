import React from 'react';
import Navigation from './components/Navigation';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ViewTickets from './components/ViewTickets';
import CreateTicket from './components/CreateTicket';
import UpdateTicket from './components/UpdateTicket';
import DeleteTicket from './components/DeleteTicket';
import NotFound from './components/NotFound';
function App() {
  return (
    <div>
      <Navigation />
      <Router>
        <Switch>
          <Route path="/" component={ViewTickets} exact />
          <Route path="/createTicket" component={CreateTicket} />
          <Route path="/update/:id" component={UpdateTicket}/>
          <Route path="/delete/:id" component={DeleteTicket}/>
          <Route component={NotFound}/>
        </Switch>
      </Router>
    </div>


  );
}

export default App;
