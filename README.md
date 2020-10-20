[![Codacy Badge](https://app.codacy.com/project/badge/Grade/ae0407bc8f3549d5aac08aba3a7b3b16)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=georgepemberton1998/sfia-3&amp;utm_campaign=Badge_Grade)

# Spring Boot Help Queue Application

This is the repo for our final project at the QA Academy
## Resources
* Presentation: [Click here](https://docs.google.com/presentation/d/1UD4ODFqCkFFhUio51SS_RvHzOjG7B9JMoznZREt4MMU/edit?usp=sharing)
## Contents 
* [Overview](#overview)
   * [Brief](#brief)
   * [Requirements](#requirements)
   * [Our Approach](#our-approach)
* [Documentation](#documentation)
   * [Kanban board](#kanban-board)
   * [CI Pipeline](#ci-pipeline)
   * [MoSCoW Analysis](#moscow-analysis)
   * [Risk Assessment](#risk-assessment)
   * [ERD](#ERD)
* [Tools used](#tools-used)
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
Tip: Click on screenshots to view them
### Kanban board 

### CI Pipeline
### MoSCoW Analysis
<p align="center">
  <img width="1400" height="550" src="https://i.imgur.com/d76jjgA.png">
</p>
### Risk Assessment
![Risk Assessment](https://user-images.githubusercontent.com/67292767/96462884-03fa8280-121e-11eb-824d-22b1939d3d59.jpg)

### ERD
![ERD Diagram](https://user-images.githubusercontent.com/67292767/96587972-f3f4a880-12da-11eb-8ddd-4458962648f6.jpg)

## Tools used

## Authors/Contributors
- George Pemberton 
- Keenan Bratley
- Macaulay Farrell


