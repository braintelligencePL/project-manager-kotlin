package pl.braintelligence.projectmanager.project.base

import pl.braintelligence.projectmanager.base.BaseUnitTest
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.domain.ProjectFactory
import pl.braintelligence.projectmanager.core.projects.domain.Status
import pl.braintelligence.projectmanager.core.projects.domain.configuration.InMemoryProjectRepository
import pl.braintelligence.projectmanager.core.projects.domain.configuration.ProjectConfiguration
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort

class BaseProjectUnitTest extends BaseUnitTest {

    protected InMemoryProjectRepository inMemoryProjectRepository = new InMemoryProjectRepository()

    protected ProjectCreatorPort projectCreator =
            new ProjectConfiguration()
                    .buildProjectCreator(Mock(ProjectFactory), inMemoryProjectRepository)

    protected ProjectQueryPort projectQuery =
            new ProjectConfiguration()
                    .buildProjectQuery(inMemoryProjectRepository)

    protected void verifyProjectDraft(Project project) {
        assert with(project) {
            id != null
            name == newProjectDraftDto.projectName
            status == Status.TO_DO
            teamAssigned == ""
            features == []
        }
    }

    protected void verifyProjectWithFeatures(Project project) {
        assert with(project) {
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
