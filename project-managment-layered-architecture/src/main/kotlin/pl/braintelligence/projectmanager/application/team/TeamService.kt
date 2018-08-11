package pl.braintelligence.projectmanager.application.team

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import pl.braintelligence.projectmanager.application.team.dto.ExistingTeamDto
import pl.braintelligence.projectmanager.application.team.dto.NewTeamDto
import pl.braintelligence.projectmanager.domain.Team
import pl.braintelligence.projectmanager.domain.TeamRepository

@Service
class TeamService(
        val teamRepository: TeamRepository
) {
    fun createTeam(newTeamDto: NewTeamDto) {
        val team = Team(newTeamDto.name)

        if(teamRepository.exist(team.name)) {
            throw TeamAlreadyExistException("Team already exists")
        }

        teamRepository.save(team)
    }

    fun getTeams(): List<ExistingTeamDto> {
        val teams = teamRepository.findAll()

        return ExistingTeamDto.mapToExistingTeams(teams)
    }
}

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Team already exists")
internal class TeamAlreadyExistException(msg: String) : RuntimeException(msg)
