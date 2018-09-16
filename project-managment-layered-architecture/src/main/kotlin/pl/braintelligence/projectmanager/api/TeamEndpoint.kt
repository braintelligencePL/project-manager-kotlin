package pl.braintelligence.projectmanager.api

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.application.dto.NewTeamDto
import pl.braintelligence.projectmanager.application.TeamService
import pl.braintelligence.projectmanager.application.dto.ExistingTeamDto
import pl.braintelligence.projectmanager.application.dto.TeamMemberDto

@RestController
@RequestMapping(value = ["/teams"])
class TeamEndpoint(
    private val teamService: TeamService
) {

    @ResponseStatus(CREATED)
    @PostMapping
    fun createTeam(@RequestBody newTeamDto: NewTeamDto) {
        teamService.createTeam(newTeamDto)
    }

    @ResponseStatus(CREATED)
    @PostMapping("{teamName}/members")
    fun addMemberToTeam(@PathVariable teamName: String, @RequestBody teamMemberDto: TeamMemberDto) {
        teamService.addMemberToTeam(teamName, teamMemberDto)
    }

    @ResponseStatus(OK)
    @GetMapping
    fun getTeams(): List<ExistingTeamDto> {
        return teamService.getTeams()
    }
}
