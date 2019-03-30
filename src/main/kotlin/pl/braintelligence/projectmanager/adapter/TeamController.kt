package pl.braintelligence.projectmanager.adapter

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.adapter.ExistingTeam.Companion.toExistingTeams
import pl.braintelligence.projectmanager.core.team.ports.`in`.TeamManager

/**
 * Primary Adapter
 */

@RestController
@RequestMapping("/teams")
class TeamEndpoint(
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
    fun getTeams(): List<ExistingTeam> =
            toExistingTeams(teamManager.getTeams())

}

