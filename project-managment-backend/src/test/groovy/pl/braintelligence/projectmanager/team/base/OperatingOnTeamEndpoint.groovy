package pl.braintelligence.projectmanager.team.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.api.team.dto.NewTeamDto
import pl.braintelligence.projectmanager.base.BaseHttpMethods

trait OperatingOnTeamEndpoint implements BaseHttpMethods {

    ResponseEntity createNewTeam(Object requestBody) {
        return post('/teams', requestBody)
    }

    ResponseEntity addMemberToTeam(Object requestBody, NewTeamDto newTeamDto) {
        def teamName = newTeamDto.name
        return post("/teams/$teamName/member", requestBody)
    }

    ResponseEntity getExistingTeams() {
        return get("/teams", List)
    }
}
