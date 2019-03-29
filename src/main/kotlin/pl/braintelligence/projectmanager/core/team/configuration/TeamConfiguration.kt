package pl.braintelligence.projectmanager.core.team.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.braintelligence.projectmanager.core.team.ports.`in`.TeamManager
import pl.braintelligence.projectmanager.core.team.ports.out.TeamRepository
import pl.braintelligence.projectmanager.core.team.domain.TeamFacade

@Configuration
class TeamConfiguration {

    fun teamManager(): TeamManager =
            teamManager(InMemoryTeamRepository())

    @Bean
    fun teamManager(teamRepository: TeamRepository): TeamManager =
            TeamFacade(teamRepository)
}
