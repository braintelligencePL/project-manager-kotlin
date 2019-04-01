
#### [![Build Status](https://travis-ci.com/braintelligencePL/project-manager-kotlin.svg?branch=master)](https://travis-ci.com/braintelligencePL/project-manager-kotlin) 🛠 

### [Project-Manager - just like trello but only backend](https://github.com/braintelligencePL/project-manager-kotlin) 
#### Journey from layered (n-tier) architecture to hexagonal architecture in Kotlin 💪
Project-Manager is a simple application for managing projects at company. You can create teams and add members to it. You can create, modify projects and assing teams to them. (basically something similar to Trello - [wiki](https://en.wikipedia.org/wiki/Project_management_software))

We'll go from traditional layered architecture to hexagonal architecture A.K.A. Ports and Adapters architecture.

#### Working with Project-Manager

`./gradlew bootRun` - to run application. <BR>
`./gradlew test` - to run unit tests. <BR>
`./gradlew clean build test`- one to rule them all 💍 <BR>
<BR>

## Implementation step-by-step

<BR>
  
### 1️⃣ `branch: step-1-team` <br>
🏠 **Architecture**: Layered Architecure <BR>
🕳 **Tests**: Integration/Acceptance with TDD/BDD approach (more like BDD).

* [x] `POST: /teams` - create a team. <br>
* [x] `POST: /teams/:teamName/members` - add members to the team. <br>
* [x] `GET: /teams` - show teams. <br> <br>

Needs and constraints: 
* Team cannot be created if already exists
* How many projects team has? 


<BR>

### 2️⃣ `branch: step-2-projects` <br>
🏠 **Architecture**: Layered Architecure <BR>
🕳 **Tests**: Integration/Acceptance with TDD/BDD approach (more like BDD).

* [x] `POST: /projects/drafts` - create project draft (only project name). <br>
* [x] `POST: /projects` - create full project (project with features📊). <br>
* [x] `GET: /projects` - show draft projects <br>

Needs and constraints: 
* JobPosition must be valid (Developer, Scrum Master...)
* Team can have no more than 3 projects at the time

### 3️⃣ `branch: step-3-refactor` <br> 
🏠 **Architecture**: Hexagonal Architecure <BR>

Things done: 

* Layered (n-tier) architecture to hexagonal architecture
* Improved tests, domain is mainly tested with unit tests. Idea of `InMemoryRepository - as HashMap`.

<br>

### 4️⃣ `branch: step-4-projects` <br> 
🏠 **Architecture**: Hexagonal Architecure <BR>

* [ ] `GET: /projects/:id` - show project (project not project draft)<br>
* [ ] `PUT: /projects/:id` - change/update project <br>
* [ ] `PATCH: /projects/:id/started` - start team when team assigned <br>
* [ ] `PATCH: /projects/:id/ended` - close project when features are done <br><br>

<BR>

### 5️⃣ `branch: step-5-zoo-of-microservices` <br>
🏠 **Architecture**: Hexagonal Architecture (modularization on package level) <BR>
🕳 **Tests**: Integration/Acceptance/Unit<BR>
Backing-Services from [Twelve-Factor-App](https://12factor.net/) methodology.

Services from our zoo:<BR>
🦓 **user-autorization-service** - authentication gateway that protects back-end resources. There is two kinds of resources protected and unprotected. First one requires user-level authentication and second one is just read-only such as listing of offers/products. <BR><BR>
🐼 **edge-service** - gives possibility to expose unified REST API from all of ours backend services. To be able to do this, the Edge Service matches a request route’s URL fragment from a front-end application to a back-end microservice through a reverse proxy to retrieve the remote REST API response. <BR><BR>
🐰 **discovery-service** - Edge-service matches a request route’s URL fragment from a front-end application to a back-end microservice through a reverse proxy to retrieve the remote REST API response. <BR><BR>
🐿 **centralized-configuration-server** - Spring Cloud application that centralizes external configurations using various methodologies of [building twelve-factor applications](https://12factor.net/config). <BR><BR>

<BR>

### #️⃣ `branch: will-be-more` <br>
- monitoring, grafana, actuator, performance tests with gatling

<BR><BR>
  
## Technologies used: 
- Kotlin with spring 
- Spock (groovy) for tests
- ArchUnit (kotlin) for architecture tests
- Gradle to build project
  
### Materials from mine blog: 
* PL: [Prawie trywialna aplikacja do zarządzania projektami](http://braintelligence.pl/prawie-trywialna-aplikacja-do-zarzadzania-projektami) - bardziej szczegółowy opis projektu.
* ENG: [ The nature of domain driven design](http://www.braintelligence.pl/the-nature-of-domain-driven-design/) - about DDD strategic tools.

### Materials from outside world: 
* ENG: [ ddd-workshop-project-manager (most credits to this repo)](https://github.com/mkopylec/project-manager)
* ENG: [ example of hexagonal architecture (on package level)](https://github.com/jakubnabrdalik/hentai)
* ENG: [ design patterns for humans ](https://github.com/kamranahmedse/design-patterns-for-humans)
* ENG: [ ddd-laeven ](https://github.com/BottegaIT/ddd-leaven-v2)
* ENG: [ awsome-ddd ](https://github.com/heynickc/awesome-ddd)
* ENG: [ twelve-factor-app - methodology for building software-as-a-service](https://12factor.net/)
