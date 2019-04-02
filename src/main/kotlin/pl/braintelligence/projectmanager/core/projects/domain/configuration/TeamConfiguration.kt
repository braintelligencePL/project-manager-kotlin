package pl.braintelligence.projectmanager.core.projects.domain.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.braintelligence.projectmanager.core.projects.domain.ProjectCreator
import pl.braintelligence.projectmanager.core.projects.domain.ProjectFactory
import pl.braintelligence.projectmanager.core.projects.domain.ProjectQuery
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectRepository

@Configuration
open class ProjectConfiguration {

    open fun projectCreator(
            projectFactory: ProjectFactory
    ): ProjectCreatorPort =
            projectCreator(projectFactory, InMemoryProjectRepository())

    @Bean
    open fun projectCreator(
            projectFactory: ProjectFactory,
            projectRepository: ProjectRepository
    ): ProjectCreatorPort =
            ProjectCreator(projectFactory, projectRepository)


    open fun projectQuery(): ProjectQueryPort =
            projectQuery(InMemoryProjectRepository())

    @Bean
    open fun projectQuery(
            projectRepository: ProjectRepository
    ): ProjectQueryPort =
            ProjectQuery(projectRepository)


}
