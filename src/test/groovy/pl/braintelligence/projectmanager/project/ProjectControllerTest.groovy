package pl.braintelligence.projectmanager.project

import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.UpdateProject
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.ExistingTeam

class ProjectControllerTest extends BaseIntegrationTest {

    def "Should increment team numberOfOngoingProjects when team is assigned to project"() {
        given: "new team is created"
        def teamName = "123"
        prepareNewTeam(teamName)

        and: "new project is created"
        def project = prepareNewProject()

        and: "payload for updating project is prepared"
        def updateProject = new UpdateProject(project.body.name, teamName, List.of(newFeature))

        and:
        def projectId = project.body.id

        when: "team is assigned to project"
        post("/projects/$projectId", updateProject)

        and: "team is retrived"
        def team = get("/teams/$teamName", ExistingTeam.class)

        then:
        with(team.body) {
            currentlyImplementedProjects == 1
        }
    }

}
