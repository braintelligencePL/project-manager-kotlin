package pl.braintelligence.projectmanager.api

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.application.dto.NewTeam
import pl.braintelligence.projectmanager.application.team.TeamService
import pl.braintelligence.projectmanager.application.dto.ExistingTeam
import pl.braintelligence.projectmanager.application.dto.TeamMember

@RestController
@RequestMapping(value = ["/teams"])
class TeamEndpoint(
    val teamService: TeamService
) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun createTeam(@RequestBody newTeam: NewTeam) {
        teamService.createTeam(newTeam)
    }

    @PostMapping("{teamName}/members")
    @ResponseStatus(CREATED)
    fun addMemberToTeam(@PathVariable teamName: String, @RequestBody teamMember: TeamMember) {
        teamService.addMemberToTeam(teamName, teamMember)
    }

    @GetMapping
    @ResponseStatus(OK)
    fun getTeams(): List<ExistingTeam> {
        return teamService.getTeams()
    }
}
