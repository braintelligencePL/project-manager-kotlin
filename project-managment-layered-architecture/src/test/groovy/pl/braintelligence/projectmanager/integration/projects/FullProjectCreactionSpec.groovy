package pl.braintelligence.projectmanager.integration.projects

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.projects.base.OperatingOnProjectsEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.integration.projects.base.SampleNewFeature.sampleNewFeature
import static pl.braintelligence.projectmanager.integration.projects.base.SampleNewProject.sampleNewProject
import static pl.braintelligence.projectmanager.integration.projects.base.SampleNewProjectDraft.sampleNewProjectDraftDto

class FullProjectCreactionSpec extends BaseIntegrationSpec implements OperatingOnProjectsEndpoint {

    @Unroll
    def "Should not create an unnamed new full-project"() {
        when:
        def response = createFullProject(sampleNewProject(name: projectName))

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.code == 'EMPTY_PROJECT_NAME'

        where:
        projectName << ['', '  ']
    }

    @Unroll
    def "Should not create a new full-project with unnamed feature"() {
        given:
        def feature = sampleNewFeature(name: featureName)
        def fullProject = sampleNewProject(feature: feature)

        when:
        def response = createFullProject(fullProject)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.code == 'EMPTY_FEATURE_NAME'

        where:
        featureName << ['', '  ']
    }
}
