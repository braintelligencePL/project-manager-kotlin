package pl.braintelligence.projectmanager.application.team

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import pl.braintelligence.projectmanager.application.dto.NewTeam
import pl.braintelligence.projectmanager.domain.Team
import pl.braintelligence.projectmanager.domain.TeamRepository

@Service
class TeamService(
        val teamRepository: TeamRepository
) {
    fun createTeam(newTeam: NewTeam) {
        val team = Team(newTeam.name)

        if(teamRepository.exist(team.name)) {
            throw TeamAlreadyExistException("Team already exists")
        }

        teamRepository.save(team)
    }
}

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Team already exists")
internal class TeamAlreadyExistException(msg: String) : RuntimeException(msg)
