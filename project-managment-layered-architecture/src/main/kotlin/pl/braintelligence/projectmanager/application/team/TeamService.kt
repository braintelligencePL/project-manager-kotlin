package pl.braintelligence.projectmanager.application.team

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.application.dto.ExistingTeamDto
import pl.braintelligence.projectmanager.application.dto.NewTeamDto
import pl.braintelligence.projectmanager.application.dto.TeamMemberDto
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
    fun createTeam(newTeamDto: NewTeamDto) {
        logger.info("Creating new team {}.", newTeamDto)
        val team = Team(newTeamDto.name)
        when (teamRepository.existByName(team.name)) {
            true  -> throw EntityAlreadyExistsException(TEAM_ALREADY_EXISTS)
            false -> teamRepository.save(team)
        }
    }

    fun getTeams(): List<ExistingTeamDto> {
        val teams = teamRepository.findAll()

        return ExistingTeamDto.mapToExistingTeams(teams)
    }

    fun addMemberToTeam(teamName: String, teamMemberDto: TeamMemberDto) {
        val team = Team(teamName)

        teamRepository.findByName(teamName)
            ?: throw MissingEntityException(NONEXISTENT_TEAM)

        val teamMember = Employee.toEmployee(teamMemberDto)
        team.addMember(teamMember)
        teamRepository.save(team)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}
