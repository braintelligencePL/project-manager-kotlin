package pl.braintelligence.projectmanager.project.domain

import pl.braintelligence.projectmanager.core.projects.domain.InvalidProjectFeatureException
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.NewFeature
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.ProjectWithFeatures
import pl.braintelligence.projectmanager.project.base.BaseProjectUnitTest

class ProjectFeaturesValidationTest extends BaseProjectUnitTest {

    def "Should not allow to create project feature"() {
        when:
        def feature = [new NewFeature(featureName, status, priorityLevel)]
        projectCreator.createProjectWithFeatures(
                new ProjectWithFeatures("123", feature)
        )

        then:
        def thrown = thrown(InvalidProjectFeatureException)
        thrown.message == errorMessage

        where:
        featureName | status           | priorityLevel            | errorMessage
        ""          | "TO_DO"          | "NOT_DEFINED"            | "Project feature must have a name."
        "    "      | "TO_DO"          | "NOT_DEFINED"            | "Project feature must have a name."
        "123"       | "invalid status" | "NOT_DEFINED"            | "Project feature must have valid status."
        "123"       | "TO_DO"          | "invalid priority level" | "Project feature must have valid priority level."
    }

}
