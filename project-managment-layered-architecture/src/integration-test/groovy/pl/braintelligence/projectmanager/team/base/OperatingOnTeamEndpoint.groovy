package pl.braintelligence.projectmanager.team.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.base.BaseHttpMethodsTest

import static SampleNewTeamDto.sampleNewTeamDto

trait OperatingOnTeamEndpoint implements BaseHttpMethodsTest {

    ResponseEntity postNewTeam(Object requestBody) {
        return post('/teams', requestBody)
    }

    ResponseEntity getTeams() {
        return get("/teams", List)
    }
}