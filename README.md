
## [WIP] Project-Manager 
Project-Manager is a simple application for managing projects at company. You can create teams and add members to it. You can create, modify projects and assing teams to them. (basically something similar to Trello - [wiki](https://en.wikipedia.org/wiki/Project_management_software))

#### Working with Project-Manager

`./gradlew bootRun` - to run application. <BR>
`./gradlew test` - to run unit tests. <BR>
`./gradlew integrationTest` - to run integration tests. <BR>
`./gradlew clean build test integrationTest`- one to rule them all 💍 <BR>
<BR>

## Implementation step-by-step
### 1️⃣ `branch: step-1-team` <br>
🏠 **Architecture**: Layered Architecure <BR>
🕳 **Tests**: Integration/Acceptance with TDD/BDD approach (more like BDD).

* [x] `POST: /teams` - create a team. <br>
* [x] `POST: /teams/:teamName/members` - add members to the team. <br>
* [x] `GET: /teams` - show teams. <br> <br>

#### Tests naming convention
* SampleAcceptanceSpec - shows possitive flow of bounded context
* SampleCreationalSpec, SampleUpdate etc. - tests corner cases

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

Services from our zoo:<BR>
🦓 **user-autorization-service** - authentication gateway that protects back-end resources. There is two kinds of resources protected and unprotected. First one requires user-level authentication and second one is just read-only such as listing of offers/products. <BR><BR>
🐼 **edge-service** - gives possibility to expose unified REST API from all of ours backend services. <BR><BR>
🐰 **discovery-service** - Edge-service matches a request route’s URL fragment from a front-end application to a back-end microservice through a reverse proxy to retrieve the remote REST API response. <BR><BR>
🐿 **centralized-configuration-server** - Spring Cloud application that centralizes external configurations using various methodologies of [building twelve-factor applications](https://12factor.net/config). <BR><BR>

### #️⃣ `branch: will-be-more` <br>
- asynchrnous examples - JavaRx or Coroutines (somewhere, sometime)

<BR><BR>
  
## Technologies used: 
- kotlin with spring 
- groovy (spock) for tests
- gradle to build project
- docker in the future
  
#### Something to read on my site and credits from repos that were inspiration
* [Prawie trywialna aplikacja do zarządzania projektami (PL)](http://braintelligence.pl/prawie-trywialna-aplikacja-do-zarzadzania-projektami)
* [Strategic Tools from Domain-Driven-Design (ENG)](http://www.braintelligence.pl/the-nature-of-domain-driven-design/) 
* [ #1 ](https://github.com/kamranahmedse/design-patterns-for-humans)[ #2 ](https://github.com/BottegaIT/ddd-leaven-v2)[ #3 ](https://github.com/mkopylec/project-manager)[ #4 ](https://github.com/jakubnabrdalik/hentai) [ #5 ](https://github.com/heynickc/awesome-ddd)[ #6 ](https://github.com/kbastani/spring-cloud-event-sourcing-example)
<BR>

#### Other resources
* [Twelve-Factor-App - methodology for building software-as-a-service](https://12factor.net/)
