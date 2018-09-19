package pl.braintelligence.projectmanager.api

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.application.dto.NewTeam
import pl.braintelligence.projectmanager.application.TeamService
import pl.braintelligence.projectmanager.application.dto.ExistingTeam
import pl.braintelligence.projectmanager.application.dto.TeamMember

@RestController
@RequestMapping(value = ["/teams"])
class TeamEndpoint(
    private val teamService: TeamService
) {

    @ResponseStatus(CREATED)
    @PostMapping
    fun createTeam(@RequestBody newTeam: NewTeam) {
        teamService.createTeam(newTeam)
    }

    @ResponseStatus(CREATED)
    @PostMapping("{teamName}/members")
    fun addMemberToTeam(@PathVariable teamName: String, @RequestBody teamMember: TeamMember) {
        teamService.addMemberToTeam(teamName, teamMember)
    }

    @ResponseStatus(OK)
    @GetMapping
    fun getTeams(): List<ExistingTeam> {
        return teamService.getTeams()
    }
}
