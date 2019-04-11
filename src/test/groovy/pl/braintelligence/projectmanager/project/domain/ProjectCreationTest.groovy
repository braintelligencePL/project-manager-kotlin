package pl.braintelligence.projectmanager.project.domain


import pl.braintelligence.projectmanager.project.base.BaseProjectUnitTest

class ProjectCreationTest extends BaseProjectUnitTest {

    def "Should create a project draft and browse for it"() {
        when:
        def project = projectCreator.createProjectDraft(newProjectDraftDto)

        then:
        verifyProjectDraft(project)
    }

    def "Should create project with features and browse it"() {
        when:
        def project = projectCreator.createProjectWithFeatures(newProjectWithFeaturesDto)

        then:
        verifyProjectWithFeatures(project)
    }
}
