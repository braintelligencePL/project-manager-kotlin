package pl.braintelligence.projectmanager.integration.projects

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.projects.base.OperatingOnProjectsEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.CREATED
import static pl.braintelligence.projectmanager.integration.projects.base.SampleNewFeature.sampleNewFeature
import static pl.braintelligence.projectmanager.integration.projects.base.SampleNewProject.sampleNewProject
import static pl.braintelligence.projectmanager.integration.projects.base.SampleNewProjectDraft.sampleNewProjectDraftDto

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
        def feature = sampleNewFeature()
        def fullProject = sampleNewProject(feature: feature)

        when:
        def response = createFullProject(fullProject)

        then:
        response.statusCode == CREATED

        where:
        requirement << ['OPTIONAL', 'NECESSARY']
    }

}
