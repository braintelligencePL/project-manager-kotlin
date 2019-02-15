package pl.braintelligence.projectmanager.projects

import pl.braintelligence.projectmanager.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.projects.base.OperatingOnProjectsEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.projects.base.SampleNewProjectDraft.sampleNewProjectDraftDto

class DraftProjectCreactionSpec extends BaseIntegrationSpec implements OperatingOnProjectsEndpoint {

    @Unroll
    def "Should not create an unnamed new project-draft"() {
        when:
        def response = createProjectDraft(sampleNewProjectDraftDto(name: projectName))

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_PROJECT_NAME"

        where:
        projectName << ['', '  ']
    }

}
