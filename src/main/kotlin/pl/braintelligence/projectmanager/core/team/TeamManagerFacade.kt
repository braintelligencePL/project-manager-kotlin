package pl.braintelligence.projectmanager.core.team

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.adapter.NewTeam
import pl.braintelligence.projectmanager.adapter.TeamMember
import pl.braintelligence.projectmanager.core.ports.`in`.TeamManager
import pl.braintelligence.projectmanager.core.ports.out.TeamRepository
import pl.braintelligence.projectmanager.core.team.domain.Employee
import pl.braintelligence.projectmanager.core.team.domain.Team
import pl.braintelligence.projectmanager.core.team.exception.EntityAlreadyExistsException
import pl.braintelligence.projectmanager.core.team.exception.MissingTeamException

@Service
class TeamManagerFacade(
        private val teamRepository: TeamRepository
) : TeamManager {

    override fun createTeam(newTeam: NewTeam) {
        val teamName = newTeam.name

        when (teamRepository.existsByName(teamName)) {
            true -> throw EntityAlreadyExistsException("Team already exist.")
            false -> teamRepository.save(Team(teamName))
        }
    }

    override fun addMemberToTeam(teamName: String, teamMember: TeamMember) {
        val team = teamRepository.findByName(teamName)
                ?: throw MissingTeamException("Team does not exist.")

        val employee = Employee.toEmployee(teamMember)

        team.addMember(employee)

        teamRepository.save(team)
    }

    override fun getTeams(): List<Team> = teamRepository.findAll()

    override fun getTeam(teamName: String): Team =
            teamRepository.findByName(teamName)
                    ?: throw MissingTeamException("Team does not exist.")

}
