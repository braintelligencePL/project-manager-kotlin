package pl.braintelligence.projectmanager.integration.projects

import
import pl.braintelligence.projectmanager.application.dto.NewProjectDraftDto
import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec

import static org.springframework.http.HttpStatus.CREATED


class ProjectAcceptanceSpec extends BaseIntegrationSpec {

    def "Successful flow for project draft creation"() {
        given:
        def projectDraft = new NewProjectDraftDto(name: 'Project 1')

        when:
        def response = post('/projects/drafts', projectDraft)

        then:
        response.statusCode == CREATED
    }
}
