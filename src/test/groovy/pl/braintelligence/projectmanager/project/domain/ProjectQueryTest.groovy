package pl.braintelligence.projectmanager.project.domain

import pl.braintelligence.projectmanager.core.projects.domain.MissingProjectException
import pl.braintelligence.projectmanager.project.base.BaseProjectUnitTest

class ProjectQueryTest extends BaseProjectUnitTest {

    def "Should browse for project"() {
        given:
        def project = projectCreator.createProjectWithFeatures(newProjectWithFeaturesDto)

        when:
        def response = projectQuery.getProject(project.id)

        then:
        verifyProjectWithFeatures(response)
    }

    def "Should throw MissingProjectException when project does not exist"() {
        when:
        projectQuery.getProject("projectId")

        then:
        def thrown = thrown(MissingProjectException)
        thrown.message == "Project does not exist."
    }

    def "Should browse for projects"() {
        given:
        projectCreator.createProjectWithFeatures(newProjectWithFeaturesDto)
        projectCreator.createProjectDraft(newProjectDraftDto)

        when:
        def response = projectQuery.getProjects()

        then:
        response.size() == 2
    }

    def "Should throw MissingProjectException when there is no projects available"() {
        when:
        def response = projectQuery.getProjects()

        then:
        response.empty
    }
}
