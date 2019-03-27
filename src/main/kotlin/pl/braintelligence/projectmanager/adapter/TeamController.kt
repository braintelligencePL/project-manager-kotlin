package pl.braintelligence.projectmanager.adapter

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.core.ProjectManager
import pl.braintelligence.projectmanager.core.team.Team

@RestController
@RequestMapping("/teams")
class TeamController(
        private val projectManager: ProjectManager
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTeam(@RequestBody newTeam: NewTeam) =
            projectManager.createTeam(newTeam)

    fun addMemberToTeam(@PathVariable teamName: String, @RequestBody teamMember: TeamMember) =
            projectManager.addMemberToTeam(teamName, teamMember)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getTeams(): List<Team> =
            projectManager.getTeams()


}
