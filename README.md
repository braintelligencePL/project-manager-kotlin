# Project Manager 
The project manager is a simple application for managing projects at company. You can create teams and add members to it. You can create, modify projects and assing them to teams. (basically something similar to Trello - [wiki](https://en.wikipedia.org/wiki/Project_management_software))

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
Someday... 

# Application will be implemented in following steps:
## 1️⃣ [x] `branch: step-1-team` <br>
* [x] `POST /teams` - create a team. <br>
* [x] `POST /teams/:teamName/members` - add members to the team. <br>
* [x] `GET /teams` - show teams. <br> <br>

## 2️⃣ `branch: step-2-projects` <br>

## 2️⃣ `branch: step-3-microservice-zoo` <br>
## 2️⃣ `branch: step-4-microservice-zoo` <br>



## Features
- [ ] Create branches and divide project into incremental stages 
- [ ] Mock sample data into DB on start
- [ ] Task priority and sorting list
- [ ] Sort by createdAt and priority? 
- [ ] OAuth2 for login/registration
- [ ] Search all tasks by text ( configure elasticsearch )
- [ ] Public and private endpoints ( plus useless endpoint that counts users )


### Something to read and credits
* [Strategic Tools from Domain-Driven-Design (ENG)](http://www.braintelligence.pl/the-nature-of-domain-driven-design/) 
<BR>
* [#0 Prawie trywialna aplikacja do zarządzania projektami (PL)](http://braintelligence.pl/prawie-trywialna-aplikacja-do-zarzadzania-projektami)

#### [ #1 ](https://github.com/kamranahmedse/design-patterns-for-humans)[ #2 ](https://github.com/BottegaIT/ddd-leaven-v2)[ #3 ](https://github.com/mkopylec/project-manager)[ #4 ](https://github.com/jakubnabrdalik/hentai) [ #5 ](https://github.com/heynickc/awesome-ddd)[ #6 ](https://github.com/kbastani/spring-cloud-event-sourcing-example)

