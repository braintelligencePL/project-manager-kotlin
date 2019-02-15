package pl.braintelligence.projectmanager.projects

import pl.braintelligence.projectmanager.api.project.dto.NewFeature
import pl.braintelligence.projectmanager.api.project.dto.NewProject
import pl.braintelligence.projectmanager.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.projects.base.OperatingOnProjectsEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.projects.base.SampleNewProject.sampleNewProject

class FullProjectCreactionSpec extends BaseIntegrationSpec implements OperatingOnProjectsEndpoint {

    @Unroll
    def "Should not create an unnamed new full-project"() {
        when:
        def response = createFullProject(sampleNewProject(name: projectName))

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_PROJECT_NAME"

        where:
        projectName << ['', '  ']
    }

    @Unroll
    def "Should not create a new full-project with unnamed feature"() {
        given:
        def feature = new NewFeature("feature name", featureName)
        def fullProject = new NewProject('project name',[feature])

        when:
        def response = createFullProject(fullProject)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == 'INVALID_FEATURE_REQUIREMENT'

        where:
        featureName << ['', '  ']
    }
}
