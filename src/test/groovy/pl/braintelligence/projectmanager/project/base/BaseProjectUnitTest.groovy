package pl.braintelligence.projectmanager.project.base

import pl.braintelligence.projectmanager.base.BaseUnitTest
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.domain.ProjectFactory
import pl.braintelligence.projectmanager.core.projects.domain.configuration.InMemoryProjectRepository
import pl.braintelligence.projectmanager.core.projects.domain.configuration.ProjectConfiguration
import pl.braintelligence.projectmanager.core.projects.domain.services.ProjectQueryService
import pl.braintelligence.projectmanager.core.projects.domain.values.Status
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectModifierPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.ProjectWithFeatures

class BaseProjectUnitTest extends BaseUnitTest {

    protected InMemoryProjectRepository inMemoryProjectRepository = new InMemoryProjectRepository()

    protected ProjectCreatorPort projectCreator =
            new ProjectConfiguration()
                    .buildProjectCreator(Mock(ProjectFactory), inMemoryProjectRepository)

    protected ProjectQueryPort projectQuery =
            new ProjectConfiguration()
                    .buildProjectQuery(inMemoryProjectRepository)

    protected ProjectModifierPort projectModifier =
            new ProjectConfiguration()
                    .buildProjectModifier(
                    new ProjectQueryService(inMemoryProjectRepository),
                    inMemoryProjectRepository,
                    Mock(TeamManager))

    protected void verifyProjectDraft(Project project) {
        assert with(project) {
            id != null
            name == newProjectDraftDto.projectName
            status == Status.TO_DO
            teamAssigned.isBlank()
            features == []
        }
    }

    protected void verifyProjectWithFeatures(
            Project project,
            ProjectWithFeatures projectWithFeatures = newProjectWithFeaturesDto) {
        assert with(project) {
            id != null
            name == projectWithFeatures.projectName
            status == Status.TO_DO
            teamAssigned.isBlank()
            with(features[0]) {
                name == projectWithFeatures.features[0].name
                status == projectWithFeatures.features[0].status
                priorityLevel == projectWithFeatures.features[0].priorityLevel
            }
        }
    }
}

