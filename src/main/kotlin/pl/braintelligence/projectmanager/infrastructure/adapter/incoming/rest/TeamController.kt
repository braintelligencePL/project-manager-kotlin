package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ExistingTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ExistingTeam.Companion.toExistingTeams
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.NewTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.TeamMember

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
    fun getTeams(): List<ExistingTeam> =
            toExistingTeams(teamManager.getTeams())

}

