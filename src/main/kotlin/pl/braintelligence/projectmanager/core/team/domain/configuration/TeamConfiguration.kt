package pl.braintelligence.projectmanager.core.team.domain.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.braintelligence.projectmanager.core.team.domain.TeamFacade
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager
import pl.braintelligence.projectmanager.core.team.ports.outgoing.TeamRepository

@Configuration
open class TeamConfiguration {

    open fun teamManager(): TeamManager =
            teamManager(InMemoryTeamRepository())

    @Bean
    open fun teamManager(teamRepository: TeamRepository): TeamManager =
            TeamFacade(teamRepository)
}
