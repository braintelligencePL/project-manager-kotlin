package pl.braintelligence.projectmanager.application

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.application.dto.ExistingTeam
import pl.braintelligence.projectmanager.application.dto.NewTeam
import pl.braintelligence.projectmanager.application.dto.TeamMember
import pl.braintelligence.projectmanager.domain.exceptions.EntityAlreadyExistsException
import pl.braintelligence.projectmanager.domain.exceptions.ErrorCode.NONEXISTENT_TEAM
import pl.braintelligence.projectmanager.domain.exceptions.ErrorCode.TEAM_ALREADY_EXISTS
import pl.braintelligence.projectmanager.domain.exceptions.MissingEntityException
import pl.braintelligence.projectmanager.domain.team.Team
import pl.braintelligence.projectmanager.domain.team.TeamRepository
import pl.braintelligence.projectmanager.domain.values.Employee
import java.lang.invoke.MethodHandles

@Service
class TeamService(
    val teamRepository: TeamRepository
) {
    fun createTeam(newTeam: NewTeam) {
        logger.info("Creating new team {}.", newTeam)
        val team = Team(newTeam.name)
        when (teamRepository.existByName(team.name)) {
            true  -> throw EntityAlreadyExistsException(TEAM_ALREADY_EXISTS)
            false -> teamRepository.save(team)
        }
    }

    fun getTeams(): List<ExistingTeam> {
        val teams = teamRepository.findAll()

        return ExistingTeam.mapToExistingTeams(teams)
    }

    fun addMemberToTeam(teamName: String, teamMember: TeamMember) {
        val team = Team(teamName)

        teamRepository.findByName(teamName)
            ?: throw MissingEntityException(NONEXISTENT_TEAM)

        Employee.toEmployee(teamMember).apply {
            team.addMember(this)
        }
        Employee.toEmployee(teamMember).apply { team.addMember(this) }

        teamRepository.save(team)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}
