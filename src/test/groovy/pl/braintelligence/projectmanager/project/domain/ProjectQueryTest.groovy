package pl.braintelligence.projectmanager.project.domain

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

}
