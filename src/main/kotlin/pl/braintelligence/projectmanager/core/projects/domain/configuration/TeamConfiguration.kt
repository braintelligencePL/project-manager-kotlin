package pl.braintelligence.projectmanager.core.projects.domain.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.braintelligence.projectmanager.core.projects.domain.ProjectCreatorService
import pl.braintelligence.projectmanager.core.projects.domain.ProjectFactory
import pl.braintelligence.projectmanager.core.projects.domain.ProjectQueryService
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectCreatorRepository
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectQueryRepository

@Configuration
open class ProjectConfiguration {

    open fun buildProjectCreator(
            projectFactory: ProjectFactory,
            inMemoryProjectRepository: InMemoryProjectRepository
    ): ProjectCreatorPort =
            ProjectCreatorService(projectFactory, inMemoryProjectRepository)

    @Bean
    open fun buildProjectCreator(
            projectFactory: ProjectFactory,
            projectCreatorRepository: ProjectCreatorRepository
    ): ProjectCreatorPort =
            ProjectCreatorService(projectFactory, projectCreatorRepository)


    open fun buildProjectQuery(
            inMemoryProjectRepository: InMemoryProjectRepository
    ): ProjectQueryPort =
            ProjectQueryService(inMemoryProjectRepository)

    @Bean
    open fun buildProjectQuery(
            projectQueryRepository: ProjectQueryRepository
    ): ProjectQueryPort =
            ProjectQueryService(projectQueryRepository)


}
