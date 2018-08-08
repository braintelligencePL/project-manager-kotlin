package pl.braintelligence.projectmanager.team

import pl.braintelligence.projectmanager.BaseSetupIntegrationTest
import pl.braintelligence.projectmanager.application.dto.NewTeam

import static org.springframework.http.HttpStatus.CREATED

class TeamEndpointTest extends BaseSetupIntegrationTest{

    def "test"() {
        given:
        def newTeam = new NewTeam('Programisci JVMa')

        when:
        def response = post('/teams', newTeam)

        then:
        response.statusCode == CREATED
    }

}
