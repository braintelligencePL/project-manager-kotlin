# Project Manager (similar to Trello)
🌐 [Project Managment Software - wiki](https://en.wikipedia.org/wiki/Project_management_software)


You can find basic overview of Domain-Driven Design on my site: <BR>
#️⃣ [The nature of domain-driven design](http://www.braintelligence.pl/the-nature-of-domain-driven-design/)

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
* [ ] `POST /teams` - create a team. <br>
* [ ] `POST /teams/:teamName/members` - add members to the team. <br>
* [ ] `GET /teams` - show teams. <br> <br>

#### Branch `step-2-project` <br>


## Features
- [ ] Create branches and divide project into incremental stages 
- [ ] Mock sample data into DB on start
- [ ] Task priority and sorting list
- [ ] Sort by createdAt and priority? 
- [ ] OAuth2 for login/registration
- [ ] Search all tasks by text ( configure elasticsearch )
- [ ] Public and private endpoints ( plus useless endpoint that counts users )
