package pl.braintelligence.projectmanager.team.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.base.BaseHttpMethodsTest

trait OperatingOnTeamEndpoint implements BaseHttpMethodsTest {

    ResponseEntity postNewTeam(Object requestBody) {
        return post('/teams', requestBody)
    }

    ResponseEntity getAllTeams() {
        return get("/teams", List)
    }

}