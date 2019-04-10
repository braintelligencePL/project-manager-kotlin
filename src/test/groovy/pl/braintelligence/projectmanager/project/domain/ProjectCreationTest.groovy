package pl.braintelligence.projectmanager.project.domain

import pl.braintelligence.projectmanager.base.BaseUnitTest
import pl.braintelligence.projectmanager.core.projects.domain.Status

class ProjectCreationTest extends BaseUnitTest {

    def "Should create a project draft and browse for it"() {
        when:
        def project = projectCreator.createProjectDraft(newProjectDraftDto)

        then:
        project != null
    }

    def "Should create project with features"() {
        when:
        def project = projectCreator.createProjectWithFeatures(newProjectWithFeaturesDto)

        then:
        project != null
    }

    def "Should browse for project with features (defaults)"() {
        given:
        def project = projectCreator.createProjectWithFeatures(newProjectWithFeaturesDto)

        when:
        def response = projectQuery.getProject(project.id)

        then:
        with(response) {
            id != null
            name == newProjectWithFeaturesDto.projectName
            status == Status.TO_DO
            teamAssigned.isBlank()
            with(features[0]) {
                name == newProjectWithFeaturesDto.features[0].name
                status == newProjectWithFeaturesDto.features[0].status
                priorityLevel == newProjectWithFeaturesDto.features[0].priorityLevel
            }
        }
    }
}
