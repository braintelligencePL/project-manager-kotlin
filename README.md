
# Applications
## Project-Manager
Project-Manager is a simple application for managing projects at company. You can create teams and add members to it. You can create, modify projects and assing teams to them. (basically something similar to Trello - [wiki](https://en.wikipedia.org/wiki/Project_management_software))

#### Working with Project-Manager

`./gradlew bootRun` - to run application. <BR>
`./gradlew test` - to run unit tests. <BR>
`./gradlew integrationTest` - to run integration tests. <BR>
`./gradlew clean build test integrationTest`- 💍 One to rule them all. <BR>
<BR>

## Microservices ZOO
🦓`user-autorization-service` <BR>
🐼 `edge-service` <BR>
🐰 `discovery-service` <BR>
🐿 `centralized-configuration-server` <BR>
<BR>

## Implementation step-by-step
### 1️⃣ `branch: step-1-team` <br>
🏠 **Architecture**: Layered Architecure <BR>
🕳 **Tests**: Integration/Acceptance with TDD/BDD approach (more like BDD).

* [x] `POST: /teams` - create a team. <br>
* [x] `POST: /teams/:teamName/members` - add members to the team. <br>
* [x] `GET: /teams` - show teams. <br> <br>

### 2️⃣ `branch: step-2-projects` <br>
🏠 **Architecture**: Layered Architecure <BR>
🕳 **Tests**: Integration/Acceptance with TDD/BDD approach (more like BDD).

* [ ] `POST: /projects/drafts` - create project draft. <br>
* [ ] `POST: /projects` - create full project (project with features📊). <br>
* [ ] `GET: /projects` - show draft projects <br>
* [ ] `GET: /projects/:id` - show project (project not project draft)<br>
* [ ] `PUT: /projects/:id` - change/update project <br>
* [ ] `PATCH: /projects/:id/started` - start team when team assigned <br>
* [ ] `PATCH: /projects/:id/ended` - close project when features are done <br>

### 3️⃣ `branch: step-3-refactor` <br>
🏠 **Architecture**: Hexagonal Architecture (modularization on package level) <BR>
🕳 **Tests**: Integration/Acceptance along with Unit-Tests for corner-cases mostly<BR>
🛸 **Features**: db-in-memory implementation (ConcurrentHashMap) for fast unit-tests and simple CQRS.<BR> 
❗❗From now on only crucial parts are going to be tested with integration-tests.

### 5️⃣ `branch: step-4-zoo-of-microservices` <br>
🏠 **Architecture**: Hexagonal Architecture (modularization on package level) <BR>
🕳 **Tests**: Integration/Acceptance/Unit<BR>
🛸 **Feature**: Event-Sourcing, Microservices, Eventual-Consistency, <BR>
Backing-Services from [Twelve-Factor-App](https://12factor.net/) methodology.

🦓`user-autorization-service` <BR>
🐼 `edge-service` <BR>
🐰 `discovery-service` <BR>
🐿 `centralized-configuration-server` <BR>

### #️⃣ `branch: will-be-more` <br>
- asynchrnous examples - JavaRx or Coroutines (somewhere, sometime)

<BR><BR>
  
## Technologies: 
- kotlin with spring 
- groovy (spock) for tests
- gradle to build project
- docker in the future
  
#### Something to read on my site and credits from repos that were inspiration (or copy/paste ideas)
* [Prawie trywialna aplikacja do zarządzania projektami (PL)](http://braintelligence.pl/prawie-trywialna-aplikacja-do-zarzadzania-projektami)
* [Strategic Tools from Domain-Driven-Design (ENG)](http://www.braintelligence.pl/the-nature-of-domain-driven-design/) 
* [ #1 ](https://github.com/kamranahmedse/design-patterns-for-humans)[ #2 ](https://github.com/BottegaIT/ddd-leaven-v2)[ #3 ](https://github.com/mkopylec/project-manager)[ #4 ](https://github.com/jakubnabrdalik/hentai) [ #5 ](https://github.com/heynickc/awesome-ddd)[ #6 ](https://github.com/kbastani/spring-cloud-event-sourcing-example)
<BR>

#### Other resources
* [Twelve-Factor-App - methodology for building software-as-a-service](https://12factor.net/)
