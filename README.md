# Project Manager (similar to Trello - [wiki](https://en.wikipedia.org/wiki/Project_management_software))

### Something to read
[Strategic Tools from Domain-Driven-Design (ENG)](http://www.braintelligence.pl/the-nature-of-domain-driven-design/) <BR>
[#0 Prawie trywialna aplikacja do zarządzania projektami (PL)](http://braintelligence.pl/prawie-trywialna-aplikacja-do-zarzadzania-projektami)

# Working with application
## Backend
To run application:
```
./gradlew bootRun
```
To run unit tests:
```
./gradlew test
```
To run integration tests:
```
./gradlew integrationTest
```
💍 One to rule them all:
```
./gradlew clean build test integrationTest
```
## Frontend

<br>

# Endpoints: <br>
## Branch `step-1-team` <br>
* [x] `POST /teams` - create a team. <br>
* [x] `POST /teams/:teamName/members` - add members to the team. <br>
* [x] `GET /teams` - show teams. <br> <br>

#### Branch `step-2-project` <br>


## Features
- [ ] Create branches and divide project into incremental stages 
- [ ] Mock sample data into DB on start
- [ ] Task priority and sorting list
- [ ] Sort by createdAt and priority? 
- [ ] OAuth2 for login/registration
- [ ] Search all tasks by text ( configure elasticsearch )
- [ ] Public and private endpoints ( plus useless endpoint that counts users )
