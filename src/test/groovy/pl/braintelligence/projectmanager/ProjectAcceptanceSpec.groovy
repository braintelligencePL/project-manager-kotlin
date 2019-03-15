package pl.braintelligence.projectmanager

import pl.braintelligence.projectmanager.api.project.dto.NewFeature
import pl.braintelligence.projectmanager.api.project.dto.NewProject
import pl.braintelligence.projectmanager.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.projects.base.OperatingOnProjectsEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.CREATED
import static pl.braintelligence.projectmanager.projects.base.SampleNewProjectDraft.sampleNewProjectDraftDto

class ProjectAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnProjectsEndpoint {

    def "Successful flow for draft-project creation"() {
        when:
        def response = createProjectDraft(sampleNewProjectDraftDto())

        then:
        response.statusCode == CREATED
    }

    @Unroll
    def "Successful flow for full-project (with features) creation"() {
        given:
        def feature = new NewFeature("feat 1", requirement)
        def project = new NewProject('Project 1', [feature])

        when:
        def response = post('/projects', project)

        then:
        response.statusCode == CREATED

        where:
        requirement << ['OPTIONAL', 'NECESSARY']
    }
}
