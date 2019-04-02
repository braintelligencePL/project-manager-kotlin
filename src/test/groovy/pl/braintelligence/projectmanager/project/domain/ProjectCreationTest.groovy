package pl.braintelligence.projectmanager.project.domain


import pl.braintelligence.projectmanager.base.BaseUnitTest
import pl.braintelligence.projectmanager.core.projects.domain.ProjectFactory
import pl.braintelligence.projectmanager.core.projects.domain.Status
import pl.braintelligence.projectmanager.core.projects.domain.configuration.ProjectConfiguration
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreator

class ProjectCreationTest extends BaseUnitTest {

    private ProjectCreator projectCreator = new ProjectConfiguration()
            .projectCreator(Mock(ProjectFactory))

    def "Should create a project draft and browse for it"() {
        when:
        def project = projectCreator.createProjectDraft(newProjectDraftDto)

        then:
        project != null
    }

    def "Should create project with features"() {
        when:
        def project = projectCreator.createProjectWithFeatures(projectWithFeaturesDto)
        then:
        project != null
    }

    def "Should browse for project with features with defaults"() {
        given:
        def project = projectCreator.createProjectWithFeatures(projectWithFeaturesDto)

        when:
        def response = projectCreator.getProject(project.id)

        then:
        with(response) {
            id != null
            name == projectWithFeaturesDto.name
            status == Status.TO_DO
            teamAssigned.isBlank()
            with(features[0]) {
                name == projectWithFeaturesDto.features[0].name
                status == projectWithFeaturesDto.features[0].status
                priorityLevel == projectWithFeaturesDto.features[0].priorityLevel
            }
        }
    }


}
