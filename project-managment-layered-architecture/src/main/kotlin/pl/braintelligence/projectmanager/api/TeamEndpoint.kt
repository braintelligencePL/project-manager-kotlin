package pl.braintelligence.projectmanager.api

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.dto.NewTeamDto
import pl.braintelligence.projectmanager.TeamService
import pl.braintelligence.projectmanager.dto.ExistingTeamDto

@RestController
@RequestMapping(value = ["/teams"])
class TeamEndpoint(
        val teamService: TeamService
) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun createTeam(@RequestBody newTeamDto: NewTeamDto) {
        teamService.createTeam(newTeamDto)
    }

    @GetMapping
    @ResponseStatus(OK)
    fun getTeams(): List<ExistingTeamDto> {
        return teamService.getTeams()
    }
}
