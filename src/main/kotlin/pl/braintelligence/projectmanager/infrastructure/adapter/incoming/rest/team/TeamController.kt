package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager

/**
 * Primary Adapter
 */

@RestController
@RequestMapping("/teams")
class TeamController(
        private val teamManager: TeamManager
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createTeam(
            @RequestBody newTeamDto: NewTeam
    ) = teamManager.createTeam(newTeamDto)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{teamName}/members")
    fun addMemberToTeam(
            @PathVariable teamName: String,
            @RequestBody teamMember: TeamMember
    ) = teamManager.addMemberToTeam(teamName, teamMember)

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun getTeams(): List<ExistingTeam> = ExistingTeam.toExistingTeams(teamManager.getTeams())

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{teamName}")
    fun getTeam(
            @PathVariable teamName: String
    ): ExistingTeam = ExistingTeam.toExistingTeam(teamManager.getTeam(teamName))

}

