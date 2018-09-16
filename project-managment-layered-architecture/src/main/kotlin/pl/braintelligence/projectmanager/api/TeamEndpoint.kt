package pl.braintelligence.projectmanager.api

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.application.dto.NewTeamDto
import pl.braintelligence.projectmanager.application.team.TeamService
import pl.braintelligence.projectmanager.application.dto.ExistingTeamDto
import pl.braintelligence.projectmanager.application.dto.TeamMemberDto

@RestController
@RequestMapping(value = ["/teams"])
class TeamEndpoint(
    private val teamService: TeamService
) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun createTeam(@RequestBody newTeamDto: NewTeamDto) {
        teamService.createTeam(newTeamDto)
    }

    @PostMapping("{teamName}/members")
    @ResponseStatus(CREATED)
    fun addMemberToTeam(@PathVariable teamName: String, @RequestBody teamMemberDto: TeamMemberDto) {
        teamService.addMemberToTeam(teamName, teamMemberDto)
    }

    @GetMapping
    @ResponseStatus(OK)
    fun getTeams(): List<ExistingTeamDto> {
        return teamService.getTeams()
    }
}
