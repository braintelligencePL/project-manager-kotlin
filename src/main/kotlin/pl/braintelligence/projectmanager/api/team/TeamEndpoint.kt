package pl.braintelligence.projectmanager.api.team

import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.api.team.dto.ExistingTeam
import pl.braintelligence.projectmanager.api.team.dto.NewTeamDto
import pl.braintelligence.projectmanager.api.team.dto.TeamMemberDto
import pl.braintelligence.projectmanager.application.TeamService

@RestController
@RequestMapping(value = ["/teams"])
class TeamEndpoint(
        private val teamService: TeamService
) {

    @ResponseStatus(CREATED)
    @PostMapping
    fun createTeam(
            @RequestBody newTeamDto: NewTeamDto
    ) = teamService.createTeam(newTeamDto)


    @ResponseStatus(CREATED)
    @PostMapping("{teamName}/member")
    fun addMemberToTeam(
            @PathVariable teamName: String,
            @RequestBody teamMemberDto: TeamMemberDto
    ) = teamService.addMemberToTeam(teamName, teamMemberDto)

    @ResponseStatus(OK)
    @GetMapping
    fun getTeams(): List<ExistingTeam> = teamService.getTeams()

}
