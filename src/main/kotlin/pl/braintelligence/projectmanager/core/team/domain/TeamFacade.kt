package pl.braintelligence.projectmanager.core.team.domain

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.team.domain.values.Employee
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager
import pl.braintelligence.projectmanager.core.team.ports.outgoing.TeamRepository
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.NewTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.TeamMember

@Service
class TeamFacade(
        private val teamRepository: TeamRepository
) : TeamManager {

    override fun updateTeam(team: Team) {
        teamRepository.save(team)
    }

    override fun createTeam(newTeam: NewTeam): Team {

        val team = Team(name = newTeam.name)

        when (teamRepository.existsByName(newTeam.name)) {
            true -> throw EntityAlreadyExistsException("Team already exist.")
            false -> teamRepository.save(team)
        }

        return team
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
