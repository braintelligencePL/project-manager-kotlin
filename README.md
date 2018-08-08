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
Team has a name. (`name`) <br>
Team has projects that it currently implementing. (`currentlyImplementedProjects`) <br>
User can add <b>members</b> to a <b>team</b>. <b>Members</b> are company <b>employees</b>. (``) <br> <br>

#### Branch `step-2-project` <br>


## Features
- [ ] Create branches and divide project into incremental stages 
- [ ] Mock sample data into DB on start
- [ ] Task priority and sorting list
- [ ] Sort by createdAt and priority? 
- [ ] OAuth2 for login/registration

## Additional features
- [ ] Search all tasks by text ( configure elasticsearch )
- [ ] Public and private endpoints ( plus useless endpoint that counts users )

## Possible optimizations (future)
- [ ] Don't return whole object TasksList take just tasks `GET /lists/:id` ---> `GET /lists/:id/tasks`

<br>

## Fixes (to verify)
`public static Task mapToTask(NewTaskDto newTaskDto)` - probably setting TaskState in mapper is a bad idea

# Implemented in architectures

### To do List - Layered Service (in progress)
Sample REST service implemented using most popular **Layered Architecture**.

### To do List - Hexagonal Service (soon)
Sample REST service implemented using **Hexagonal Architecture**. 

### To do List - Frontend (soon)
Will be implemented in React.js


# Refactor todo:
- [ ] TasksList rename to TodoList

