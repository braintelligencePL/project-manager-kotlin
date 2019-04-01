package pl.braintelligence.projectmanager.core.team.domain

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager
import pl.braintelligence.projectmanager.core.team.ports.outgoing.TeamRepository
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.NewTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.TeamMember

@Service
class TeamFacade(
        private val teamRepository: TeamRepository
) : TeamManager {

    override fun createTeam(newTeam: NewTeam) = when (teamRepository.existsByName(newTeam.name)) {
        true -> throw EntityAlreadyExistsException("Team already exist.")
        false -> teamRepository.save(Team(name = newTeam.name))
    }

    override fun addMemberToTeam(teamName: String, teamMember: TeamMember) {
        val team = getTeam(teamName)

        Employee.mapToEmployee(teamMember)
                .apply { team.addMember(this) }
                .also { teamRepository.save(team) }
    }

    override fun getTeams(): List<Team> =
            teamRepository.findAll()

    override fun getTeam(teamName: String): Team =
            teamRepository.findByName(teamName)
                    ?: throw MissingTeamException("Team does not exist.")

}
