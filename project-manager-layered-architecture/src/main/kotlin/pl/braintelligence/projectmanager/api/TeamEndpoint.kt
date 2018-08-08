package pl.braintelligence.projectmanager.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.projectmanager.application.dto.NewTeam
import pl.braintelligence.projectmanager.application.team.TeamService

@RestController
@RequestMapping(value = ["/teams"])
internal class TeamEndpoint(
        val teamService: TeamService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTeam(@RequestBody newTeam: NewTeam) {
        teamService.createTeam(newTeam)
    }


}
