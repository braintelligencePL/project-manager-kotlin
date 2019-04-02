package pl.braintelligence.projectmanager.core.projects.domain.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.braintelligence.projectmanager.core.projects.domain.ProjectCreator
import pl.braintelligence.projectmanager.core.projects.domain.ProjectFactory
import pl.braintelligence.projectmanager.core.projects.domain.ProjectQuery
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectCreatorRepository

@Configuration
open class ProjectConfiguration {

    open fun projectCreator(
            projectFactory: ProjectFactory
    ): ProjectCreatorPort =
            projectCreator(projectFactory, InMemoryProjectCreatorRepository())

    @Bean
    open fun projectCreator(
            projectFactory: ProjectFactory,
            projectCreatorRepository: ProjectCreatorRepository
    ): ProjectCreatorPort =
            ProjectCreator(projectFactory, projectCreatorRepository)


    open fun projectQuery(): ProjectQueryPort =
            projectQuery(InMemoryProjectCreatorRepository())

    @Bean
    open fun projectQuery(
            projectCreatorRepository: ProjectCreatorRepository
    ): ProjectQueryPort =
            ProjectQuery(projectCreatorRepository)


}
