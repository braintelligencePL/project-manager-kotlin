package pl.braintelligence.projectmanager.core.projects.domain.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.braintelligence.projectmanager.core.projects.domain.ProjectFacade
import pl.braintelligence.projectmanager.core.projects.domain.ProjectFactory
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreator
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectRepository

@Configuration
open class ProjectConfiguration {

    open fun projectCreator(
            projectFactory: ProjectFactory
    ): ProjectCreator =
            projectCreator(projectFactory, InMemoryProjectRepository())

    @Bean
    open fun projectCreator(
            projectFactory: ProjectFactory,
            projectRepository: ProjectRepository
    ): ProjectCreator =
            ProjectFacade(projectFactory, projectRepository)


}
