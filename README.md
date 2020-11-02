[![Codacy Badge](https://app.codacy.com/project/badge/Grade/ae0407bc8f3549d5aac08aba3a7b3b16)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=georgepemberton1998/sfia-3&amp;utm_campaign=Badge_Grade)

# Spring Boot Help Queue Application

This is the repo for our final project at the QA Academy
## Resources
* Presentation: [Click here](https://docs.google.com/presentation/d/1UD4ODFqCkFFhUio51SS_RvHzOjG7B9JMoznZREt4MMU/edit?usp=sharing)
## Contents 
- [Overview](#overview)
   * [Brief](#brief)
   * [Requirements](#requirements)
   * [Our Approach](#our-approach)
- [Documentation](#documentation)
   * [Kanban board](#kanban-board)
   * [CI Pipeline](#ci-pipeline)
   * [MoSCoW Analysis](#moscow-analysis)
   * [Risk Assessment](#risk-assessment)
   * [ERD](#ERD)
   * [Wireframes](#wireframes)
- [Tools used](#tools-used)
- [Licensing](#Licensing)


## Overview
### Brief
To create a Help Queue Spring Boot Application with full CRUD functionality, with 3 additional features from a list provided 

### Requirements
- Create a user interface using React
- Implement full CRUD functionality including 2/3 additional features from list provided.
- Containerise application using Docker and Docker Compose.
- Integrate a working CI Pipeline for automation using Jenkins 
- Deploy application into testing and production environment
- Use Terraform to create Infrastructure required 
- Use Ansible to configure the environment
- Deploy application into a Kubernetes cluster on AWS EKS for production.
### Our Approach
The additional features we have decided to implement as a team are as follows:
- Solutions - so users can add solutions to a ticket. All solutions will be stored in a separate database.  
- Urgency - so a level of urgency can be assigned to a ticket, based upon value stored in an urgency field in the ticket table
- Topics - so topics can be assigned to tickets, based upon a field stored in a topic field in the ticket table. 

## Documentation
### Kanban board 

### MoSCoW Analysis
![MoSCoW diagram](https://i.imgur.com/tajqyXm.png)

### Risk Assessment
![Risk Assessment](https://i.imgur.com/FWQCumY.png)
![Risk Assessment_Graph](https://i.imgur.com/cnuukuB.png)

### ERD
![ERD Diagram](https://user-images.githubusercontent.com/67292767/96587972-f3f4a880-12da-11eb-8ddd-4458962648f6.jpg)

### CI Pipeline
![CI Pipeline](https://i.imgur.com/DWyH8aO.png)

### Wireframes
![View Tickets](https://i.imgur.com/1pAGrZn.png)
![Create Ticket](https://i.imgur.com/CgZDYwQ.png)
![Update Ticket](https://i.imgur.com/K7poGRQ.png)

## Tools used
* [Dev-Ops](#dev-ops)
   + [Terraform](#terraform)
   + [Ansible](#ansible)
   + [Jenkins](#jenkins)
   + [Kubernetes](#kubernetes)
   + [AWS](#aws)
* [Application](#application)
   + [Frontend](#frontend)
   + [Backend](#backend)
   + [Testing](#testing)

### Dev-Ops
<span style="color:red">image of pipeline</span> 
<p>
  <img width="150" height="200" src="https://i.imgur.com/pydg9bI.jpg">
</p>

### Terraform
<span style="color:red">What does terraform set up?  
what configuration does it do?  
Anything else</span> 

### Ansible
Ansibles key role is to increase the automation of the deployment of this application. We have used it to install and configure several dependencies which would otherwise have to be done manually. The installs take place on the instances created using terraform. Currently, there are 3 installs we have automated this way;  
**1. Jenkins**,  
On the Jenkins Host, following an SCP of a script to create a jenkins user and install it. After this, another SCP takes place which holds the desired jenkins configuration (Users, Plugins, Jobs & UI)  
**2. AWS CLI**,   
On the jenkins host, which is used to deploy the application on the Kuberenetes cluster  
**3. Docker & Docker-Compose**,  
On the Jenkins host, which is used to push the most recent images to dockerhub
On the test EC2, which is used to pull and test the most recent images from dockerhub  


### Jenkins
<span style="color:red">What does the job do?  
What did we do with the UI?  
Anything else</span>


### Kubernetes
<span style="color:red">What does it do? (deploy the app)  
How does it work?  
What does the environment look like?  
Anything else</span>

### AWS
<span style="color:red">Networking  
Anything else</span>

### Application
<span style="color:red">image of frontend</span> 
<p>
  <img width="150" height="200" src="https://i.imgur.com/pydg9bI.jpg">
</p>


### Frontend

<span style="color:red">What we did to hit the MVP  
What we did to surpass the MVP   
CSS, react</span>

### Backend
<span style="color:red">What we did to hit the MVP   
What we did to surpass the MVP  
Springboot</span>

#### Testing
<span style="color:red">Spring testing - describe  
Coverage - line method & other  
React testing - describe  
Coverage - line method & other
</span>
<br/>
<br/>
Average testing coverage:<br/>
![Average Testing coverage](https://i.imgur.com/QDs9JjF.png) <br/>
Package testing Coverage: <br/>
![Individual package testing](https://i.imgur.com/WUvCN4U.png)

## Licensing
MIT License

Copyright (c) 2020 georgepemberton1998

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Authors/Contributors
- George Pemberton 
- Keenan Bratley
- Macaulay Farrell
- Chinenye Nwandu* 

