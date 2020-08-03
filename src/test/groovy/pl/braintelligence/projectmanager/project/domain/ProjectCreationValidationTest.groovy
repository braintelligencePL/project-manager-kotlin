package pl.braintelligence.projectmanager.project.domain

import pl.braintelligence.projectmanager.core.projects.domain.InvalidProjectException
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.project.base.BaseProjectUnitTest

class ProjectCreationValidationTest extends BaseProjectUnitTest {

    def "Should create a project draft"() {
        when:
        def project = projectCreator.createProjectDraft(newProjectDraftDto)

        then:
        verifyProjectDraft(project)
    }

    def "Should create project with features"() {
        when:
        def project = projectCreator.createProjectWithFeatures(newProjectWithFeaturesDto)

        then:
        verifyProjectWithFeatures(project)
    }

    def "Should not allow to create project with empty  id, name"() {
        when:
        new Project(id, name)

        then:
        def thrown = thrown(InvalidProjectException)
        thrown.message == errorMessage

        where:
        id     | name   | errorMessage
        ""     | "name" | "Project id cannot be empty."
        "    " | "name" | "Project id cannot be empty."
        "123"  | ""     | "Project name cannot be empty."
        "123"  | "    " | "Project name cannot be empty."
    }

}
