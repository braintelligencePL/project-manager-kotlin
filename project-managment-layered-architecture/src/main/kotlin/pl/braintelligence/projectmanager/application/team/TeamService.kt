package pl.braintelligence.projectmanager.application.team

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.application.team.dto.ExistingTeamDto
import pl.braintelligence.projectmanager.application.team.dto.NewTeamDto
import pl.braintelligence.projectmanager.domain.exceptions.EntityAlreadyExistsException
import pl.braintelligence.projectmanager.domain.team.Team
import pl.braintelligence.projectmanager.domain.team.TeamRepository
import java.lang.invoke.MethodHandles

@Service
class TeamService(
        val teamRepository: TeamRepository
) {
    fun createTeam(newTeamDto: NewTeamDto) {
        logger.info("Creating new team {}.", newTeamDto)
        val team = Team(newTeamDto.name)

        when (teamRepository.existByName(team.name)) {
            true -> {
                logger.warn("Team {} already exist.", newTeamDto)
                throw EntityAlreadyExistsException("Team already exist.")
            }
            false -> teamRepository.save(team)
        }
    }

    fun getTeams(): List<ExistingTeamDto> {
        val teams = teamRepository.findAll()

        return ExistingTeamDto.mapToExistingTeams(teams)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}
