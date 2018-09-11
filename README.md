# From Zero to Hero (or something like that) - Practical-Roadmap
##### tltr; Practical-Roadmap for backend developer. 
There is lots of roadmaps on github. Most of them are simple agregators of links. I always give it a 'star', but never really use it. None of them was really helpful. I barly found one or two that was step-by-step to make a good-quality software using some good-practices. So... I have a brilliant idea I will do it myself! To be completely honest, I'm doing this project to practice all these good-practices and learn kotlin a bit better. I'm not a guru or something like that. I will try to include most of the modern approaches for wring good-quality software. Project will be more like a marathon than sprint. I'm really curious how it'll ends. It'll take me probably few months/years to complete, but in the end it'll contain a lot of knowledge that is needed for backend developer. Especially one that sits with JVM at one table. Anyway main purpose of this repo is that its not focused on technology per se, but instead on good-practices, architectures, designs in general and all other cool-things.

# What'll we do here?
## Core Application/Domain - Project Manager 
Project-Manager is a simple application for managing projects at company. You can create teams and add members to it. You can create, modify projects and assing teams to them. (basically something similar to Trello - [wiki](https://en.wikipedia.org/wiki/Project_management_software))

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

## It'll be done like this
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
🛸 **Features**: Db implementation with `ConcurrentHashMap` for fast unit-tests `InMemoryCrudRepository.kt` and simple CQRS.<BR> 
❗❗We have made a mistake by making only integration-tests time to fix that. Only crucial parts will be tested now and the rest will be in unit-tests. ❗

### 5️⃣ `branch: step-4-zoo-of-microservices` <br>
🏠 **Architecture**: Hexagonal Architecture (modularization on package level) <BR>
🕳 **Tests**: Integration/Acceptance/Unit<BR>
🛸 **Features**: Event-Sourcing, Microservices, Eventual-Consistency, <BR>
Backing-Services from [Twelve-Factor-App](https://12factor.net/) methodology.

🦓`user-autorization-service` 
🐼 `edge-service`
🐰 `discovery-service`
🐿 `centralized-configuration-server`

### #️⃣ `branch: will-be-more` <br>
- asynchrnous programming - JavaRx or Coroutines (somewhere, sometime)
- docker

<BR><BR>
  
### My blog to read and credits from repos that were inspiration (or copy/paste ideas)
* [Prawie trywialna aplikacja do zarządzania projektami (PL)](http://braintelligence.pl/prawie-trywialna-aplikacja-do-zarzadzania-projektami)
* [Strategic Tools from Domain-Driven-Design (ENG)](http://www.braintelligence.pl/the-nature-of-domain-driven-design/) 
* [ #1 ](https://github.com/kamranahmedse/design-patterns-for-humans)[ #2 ](https://github.com/BottegaIT/ddd-leaven-v2)[ #3 ](https://github.com/mkopylec/project-manager)[ #4 ](https://github.com/jakubnabrdalik/hentai) [ #5 ](https://github.com/heynickc/awesome-ddd)[ #6 ](https://github.com/kbastani/spring-cloud-event-sourcing-example)
<BR>

### Other resources
* [Twelve-Factor-App - methodology for building software-as-a-service](https://12factor.net/)
