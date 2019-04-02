package pl.braintelligence.projectmanager.project

import org.springframework.http.HttpStatus
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectDraft

class ProjectControllerTest extends BaseIntegrationTest {

    def "Should create project draft"() {
        given:
        def newProjectDraft = new ProjectDraft("project name")

        when:
        def response = post("/projects", newProjectDraft)

        then:
        response.statusCode == HttpStatus.CREATED
    }
}
