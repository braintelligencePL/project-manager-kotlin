package pl.braintelligence.projectmanager.integration.team.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.application.dto.NewTeamDto
import pl.braintelligence.projectmanager.integration.base.BaseHttpMethodsSpec

trait OperatingOnTeamEndpoint implements BaseHttpMethodsSpec {

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
