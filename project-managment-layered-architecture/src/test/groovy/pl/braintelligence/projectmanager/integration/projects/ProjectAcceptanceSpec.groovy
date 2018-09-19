package pl.braintelligence.projectmanager.integration.projects

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.projects.base.OperatingOnProjectsEndpoint

import static org.springframework.http.HttpStatus.CREATED
import static pl.braintelligence.projectmanager.integration.projects.base.SampleNewProjectDraftDto.sampleNewProjectDraftDto

class ProjectAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnProjectsEndpoint {

    def "Successful flow for project draft creation"() {
        when:
        def response = createProjectDraft(sampleNewProjectDraftDto())

        then:
        response.statusCode == CREATED
    }
}
