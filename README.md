# Project Manager 
The project manager is a simple application for managing projects at company. You can create teams and add members to team. You can create, modify projects and assing them to teams. (basically something similar to Trello - [wiki](https://en.wikipedia.org/wiki/Project_management_software))

### Working with application

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
<BR>

## It'll be implmented in following way:
### 1️⃣ `branch: step-1-team` <br>
🏠 **Architecture**: Layered Architecure <BR>
🕳 **Tests**: Integration/Acceptance with BDD approach.

* [x] `POST: /teams` - create a team. <br>
* [x] `POST: /teams/:teamName/members` - add members to the team. <br>
* [x] `GET: /teams` - show teams. <br> <br>

### 2️⃣ `branch: step-2-projects` <br>
🏠 **Architecture**: Layered Architecure <BR>
🕳 **Tests**: Integration/Acceptance with BDD approach.

* [ ] `POST: /projects/drafts` - create project draft. <br>
* [ ] `POST: /projects` - create full project (project with features📊). <br>
* [ ] `GET: /projects` - show draft projects <br>
* [ ] `GET: /projects/:id` - show project (project not project draft)<br>
* [ ] `PUT: /projects/:id` - change/update project <br>
* [ ] `PATCH: /projects/:id/started` - start team when team assigned <br>
* [ ] `PATCH: /projects/:id/ended` - close project when features are done <br>

### 3️⃣ `branch: step-3-refactor` <br>
🏠 **Architecture**: Hexagonal Architecture (modularization on package level) <BR>
🕳 **Tests**: Integration/Acceptance along with unit-tests for corner-cases mostly<BR>
🛸 **Features**: `InMemoryCrudRepository` with `ConcurrentHashMap` for fast unit-tests

### 4️⃣ `branch: step-4-microservice-zoo` <br>
🏠 **Architecture**: Hexagonal Architecture (modularization on package level) <BR>
🕳 **Tests**: Integration/Acceptance corner cases with unit-tests<BR>
🛸 **Features**: Event-Sourcing, Microservices, Eventual-Consistency <BR>

- `user-autorization-service` - 
- `edge-service`
- `discovery-service`
- `centralized-configuration-server`

### #️⃣ `branch: there-will-be-more` <br>


### Blog to read and credits from repos that were inspiration (or copy/paste ideas)
* [Strategic Tools from Domain-Driven-Design (ENG)](http://www.braintelligence.pl/the-nature-of-domain-driven-design/) 
<BR>
* [#0 Prawie trywialna aplikacja do zarządzania projektami (PL)](http://braintelligence.pl/prawie-trywialna-aplikacja-do-zarzadzania-projektami)

#### [ #1 ](https://github.com/kamranahmedse/design-patterns-for-humans)[ #2 ](https://github.com/BottegaIT/ddd-leaven-v2)[ #3 ](https://github.com/mkopylec/project-manager)[ #4 ](https://github.com/jakubnabrdalik/hentai) [ #5 ](https://github.com/heynickc/awesome-ddd)[ #6 ](https://github.com/kbastani/spring-cloud-event-sourcing-example)
