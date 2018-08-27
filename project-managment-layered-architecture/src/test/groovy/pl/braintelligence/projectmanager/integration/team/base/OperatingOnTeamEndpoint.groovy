package pl.braintelligence.projectmanager.integration.team.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.integration.base.BaseHttpMethodsSpec

trait OperatingOnTeamEndpoint implements BaseHttpMethodsSpec {

    ResponseEntity postNewTeam(Object requestBody) {
        return post('/teams', requestBody)
    }

    ResponseEntity getAllTeams() {
        return get("/teams", List)
    }

}