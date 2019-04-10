package pl.braintelligence.projectmanager.base

import pl.braintelligence.projectmanager.core.projects.domain.ProjectFactory
import pl.braintelligence.projectmanager.core.projects.domain.configuration.InMemoryProjectRepository
import pl.braintelligence.projectmanager.core.projects.domain.configuration.ProjectConfiguration
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.core.team.domain.configuration.TeamConfiguration
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager
import spock.lang.Specification

class BaseUnitTest extends Specification implements BaseDtoObjects {

    // teams
    protected TeamManager teamService = new TeamConfiguration().teamManager()

    // projects
    protected InMemoryProjectRepository inMemoryProjectRepository = new InMemoryProjectRepository()

    protected ProjectCreatorPort projectCreator =
            new ProjectConfiguration()
                    .buildProjectCreator(Mock(ProjectFactory), inMemoryProjectRepository)

    protected ProjectQueryPort projectQuery =
            new ProjectConfiguration()
                    .buildProjectQuery(inMemoryProjectRepository)

}
